package controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Portfolio;
import pojoView.BrokerView;
import pojoView.InvestorView;
import pojoView.PortfolioMemberView;
import pojoView.PortfolioView;
import service.PortfolioService;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

	
	@Autowired
	private PortfolioService service;
	
	@GetMapping
	public String listPortfolio(Model theModel){
		List<PortfolioView> portfolios = service.listPortfolioView();
		theModel.addAttribute("portfolio", portfolios);
		return "ListPortfolio";
	}
	
	@GetMapping("/portfolioDetail")
	public String portfolioDetail(@RequestParam("portfolioId") Integer theId, Model theModel){
		
		
		List<PortfolioMemberView> portfolioMember = service.getPortfolioMemberViewByPortfolioId(theId);
		PortfolioView portfolioView = service.getPortfolioViewById(theId);
		
		theModel.addAttribute("portfolioMember", portfolioMember);
		theModel.addAttribute("portfolioView", portfolioView);
		return "portfolioDetail";
	}
	
	@GetMapping("/updatePortfolio")
	public String updatePortfolio(Model theModel, @RequestParam("portfolioId") Integer portfolioId) { 
		
		Portfolio portfolio = service.getPortfolioById(portfolioId);
		List<InvestorView> investorviews = service.listInvestorView();
		List<BrokerView> brokerviews = service.listBrokerView();
		
		theModel.addAttribute("portfolio", portfolio);
		theModel.addAttribute("investorviews", investorviews);
		theModel.addAttribute("brokerviews", brokerviews);
		
		return "addPortfolioForm";
	}
	
	
	@GetMapping("/addPortfolioForm")
	public String addPortfolio(Model theModel){
		
		List<InvestorView> investorviews = service.listInvestorView();
		List<BrokerView> brokerviews = service.listBrokerView();
		
		theModel.addAttribute("portfolio", new Portfolio());
		theModel.addAttribute("investorviews", investorviews);
		theModel.addAttribute("brokerviews", brokerviews);
		
		return "addPortfolioForm";
	}
	

	@PostMapping("/savePortfolio")
	public String savePortfolio(@ModelAttribute("portfolio") Portfolio p) {
				
		service.addPortfolio(p);
		
		return "redirect:/portfolio";
	}
	
	@GetMapping("/deletePortfolio/{portfolioId}")
	public String deletePortfolio(@PathVariable("portfolioId") Integer portfolioId) {
		
		service.delPortfolioById(portfolioId);

		return "redirect:/portfolio";
	}

	
}
