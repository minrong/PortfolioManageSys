package controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Address;
import pojo.Broker;
import pojo.Investor;
import pojo.Person;
import pojoView.BrokerView;
import pojoView.InvestorView;
import service.PortfolioService;


@Controller
@RequestMapping("/people")
public class PersonController {
	
	private static Log logger = LogFactory.getLog(PersonController.class);
	
	@Autowired
	private PortfolioService service;
	
	@GetMapping("/broker")
	public String broker(Model theModel){
		List<BrokerView> bv = service.listBrokerView();
		theModel.addAttribute("bv", bv);
		return "listBroker";
	}
	

	
	@GetMapping("/addBroker")
	public String addBrokerForm(Model theModel){
		Person broker = new Broker();
		Address address = new Address();
		
		theModel.addAttribute("broker", broker);
		theModel.addAttribute("address", address);
		
		return "addBrokerForm";
	}
	

	@PostMapping("/saveBroker")
	public String saveBroker(@ModelAttribute("broker") Broker tempbroker, 
			@ModelAttribute("address") Address tempAddress) {

		service.addBroker(tempbroker, tempAddress);
		
		return "redirect:/people/broker";
	}
	
	@GetMapping("/updateBroker")
	public String updateBroker(Model theModel, @RequestParam("personId") Integer personId) { 
		
		Broker broker = service.getBrokerById(personId);
		Address address = service.getAddressByPersonId(personId);
		
		theModel.addAttribute("broker", broker);
		theModel.addAttribute("address", address);
		
		return "addBrokerForm";
	}
	

	
	@GetMapping("/investor")
	public String investor(Model theModel){
		List<InvestorView> iv = service.listInvestorView();
		theModel.addAttribute("iv", iv);
		return "listInvestor";
	}
	
	@GetMapping("/addInvestor")
	public String addInvestorForm(Model theModel){
		Person investor = new Investor();
		Address address = new Address();
		
		logger.info("hello this is personController method saveInvestor,"
				+ " personid："+investor.getPersonId()+"  addressId "+ address.getAddressId());
		

		
		theModel.addAttribute("investor", investor);
		theModel.addAttribute("address", address);
		
		return "addInvestorForm";
	}
	
	
	@PostMapping("/saveInvestor")
	public String saveInvestor(@ModelAttribute("investor") Investor tempinvestor,
			@ModelAttribute("address") Address tempAddress) {

		logger.info("hello this is personController method saveInvestor,"
				+ " personid："+tempinvestor.getPersonId()+"  addressId "+ tempAddress.getAddressId());
		service.addInvestor(tempinvestor, tempAddress);
		return "redirect:/people/investor";
	}

	
	@GetMapping("/deleteInvestor/{personId}")
	public String deleteInvestor(@PathVariable("personId") Integer personId) {
		service.delInvestorById(personId);
		return "redirect:/people/investor";
	}
	
	@GetMapping("/deleteBroker/{personId}")
	public String deleteBroker(@PathVariable("personId") Integer personId) {
		service.delBrokerById(personId);
		return "redirect:/people/broker";
	}
	

	
	@GetMapping("/updateInvestor")
	public String updateInvestor(Model theModel, @RequestParam("personId") Integer personId) { 
		
		Investor investor = service.getInvestorById(personId);
		Address address = service.getAddressByPersonId(personId);
		
		theModel.addAttribute("investor", investor);
		theModel.addAttribute("address", address);
		
		return "addInvestorForm";
	}
	

	
	

}
