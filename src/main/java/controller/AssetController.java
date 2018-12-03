package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import pojo.Asset;
import pojo.DepositAccount;
import pojo.PrivateInvestment;
import pojo.Stock;
import pojoView.DepositAccountView;
import pojoView.PrivateInvestmentView;
import pojoView.StockView;
import service.PortfolioService;

@Controller
@RequestMapping("/assets")
public class AssetController {

	@Autowired
	private PortfolioService service;
	

	@GetMapping
	public String ListAsset(Model theModel){
		List<StockView> sv = service.listStockView();
		List<PrivateInvestmentView> piv = service.listPrivateInvestmentView();
		List<DepositAccountView> dav = service.listDepositAccountView();
		theModel.addAttribute("sv", sv);
		theModel.addAttribute("piv", piv);
		theModel.addAttribute("dav", dav);
		return "ListAsset";
	}
	
	@GetMapping("/addStockForm")
	public String addStockForm(Model theModel){
		Asset stocks = new Stock();
		
		theModel.addAttribute("stock", stocks);
		
		return "addStockForm";
	}
	
	
	@GetMapping("/addPrivateInvestmentForm")
	public String addPrivateInvestmentFrom(Model theModel){
		
		theModel.addAttribute("privateInvestment", new PrivateInvestment());
		
		return "addPrivateInvestmentForm";
	}
	

	@GetMapping("/addDepositAccountForm")
	public String addDepositAccountForm(Model theModel){
		
		theModel.addAttribute("depositAccount", new DepositAccount());
		
		return "addDepositAccountForm";
	}
	
	@PostMapping("/saveStock")
	public String saveStock(@ModelAttribute("stock") Stock tempStock) {

		service.addStock(tempStock);
		
		return "redirect:/assets";
	}
	
	@PostMapping("/saveDepositAccount")
	public String saveDepositAccount(@ModelAttribute("depositAccount") DepositAccount tempda) {

		service.addDepositAccount(tempda);
		
		return "redirect:/assets";
	}
	
	@PostMapping("/savePrivateInvestment")
	public String savePrivateInvestment(@ModelAttribute("privateInvestment") PrivateInvestment pis) {

		service.addPrivateInvestment(pis);
		
		return "redirect:/assets";
	}
	
	
	@GetMapping("/deleteAsset/{assetId}")
	public String deleteAsset(@PathVariable("assetId") Integer assetId) {
		service.delAssetById(assetId);

		return "redirect:/assets";
	}
	
	@GetMapping("/updateDepositAccount")
	public String updateDepositAccount(Model theModel, @RequestParam("assetId") Integer assetId) { 
		
		DepositAccount depositAccount = service.getDepositAccountById(assetId);
		
		theModel.addAttribute("depositAccount", depositAccount);

		
		return "addDepositAccountForm";
	}
	
	@GetMapping("/updateStock")
	public String updateStock(Model theModel, @RequestParam("assetId") Integer assetId) { 
		
		Stock stocks = service.getStockById(assetId);
		
		theModel.addAttribute("stock", stocks);

		return "addStockForm";
	}
	
	@GetMapping("/updatePrivateInvestment")
	public String updatePrivateInvestment(Model theModel, @RequestParam("assetId") Integer assetId) { 
		
		PrivateInvestment privateInvestment = service.getPrivateInvestmentById(assetId);
		
		theModel.addAttribute("privateInvestment", privateInvestment);

		return "addPrivateInvestmentForm";
	}
	
}
