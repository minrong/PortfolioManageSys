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
import pojo.PortfolioMember;
import pojoView.DepositAccountView;
import pojoView.PrivateInvestmentView;
import pojoView.StockView;
import service.PortfolioService;

@Controller
@RequestMapping("/portfolioMember")
public class PortfolioMemberController {

	@Autowired
	private PortfolioService service;
	
	
	@GetMapping("/addSMemberForm")
	public String addSMemberForm(Model theModel, @RequestParam(value="portfolioId", required=false) Integer portfolioId ){

		List<StockView> stocks = service.listStockView();
		PortfolioMember portfolioMember = new PortfolioMember();
		portfolioMember.setPortfolioId(portfolioId);
		
		theModel.addAttribute("portfolioMember", portfolioMember);
		theModel.addAttribute("stockView", stocks);
		
		return "addSMemberForm";
	}
	
	@GetMapping("/addDMemberForm")
	public String addDMemberForm(Model theModel, @RequestParam(value="portfolioId", required=false) Integer portfolioId ){

		List<DepositAccountView> depositAccounts = service.listDepositAccountView();
		PortfolioMember portfolioMember = new PortfolioMember();
		portfolioMember.setPortfolioId(portfolioId);
		
		theModel.addAttribute("portfolioMember", portfolioMember);
		theModel.addAttribute("depositAccountView", depositAccounts);
		
		return "addDMemberForm";
	}
	
	@GetMapping("/addPMemberForm")
	public String addPMemberForm(Model theModel, @RequestParam(value="portfolioId",required=false) Integer portfolioId ){

		List<PrivateInvestmentView> privateInvestments = service.listPrivateInvestmentView();
		PortfolioMember portfolioMember = new PortfolioMember();
		portfolioMember.setPortfolioId(portfolioId);
		
		theModel.addAttribute("portfolioMember", portfolioMember);
		theModel.addAttribute("privateInvestmentView", privateInvestments);
		
		return "addPMemberForm";
	}
	
	
	@PostMapping("/savePortfolioMember")
	public String saveStock(@ModelAttribute("portfolioMember") PortfolioMember p) {
		
		System.out.println(p.getPortfolioId());
		service.addPortfolioMember(p);
		
		return "redirect:/portfolio";
	}
	
	@GetMapping("/updatePortfolioMember")
	public String updatePortfolioMember(Model theModel, @RequestParam(value = "portfolioMemberId",required=true) Integer portfolioMemberViewId) { 
		
		
		PortfolioMember pm = service.getPortfolioMemberById(portfolioMemberViewId);
		Asset a = service.getAssetById(pm.getAssetId());
		
		theModel.addAttribute("portfolioMember", pm);
		
		if (a.accountType() == "D") {
			theModel.addAttribute("depositAccountView", service.listDepositAccountView());
			return "addDMemberForm";
		}else if(a.accountType() == "P") {
			theModel.addAttribute("privateInvestmentView", service.listPrivateInvestmentView());
			return "addPMemberForm";
		}else {
			System.out.println(a.accountType());
			theModel.addAttribute("stockView", service.listStockView());
			return "addSMemberForm";
		}

	}
	
	@GetMapping("/deletePortfolioMember/{portfolioMemberId}")
	public String deletePortfolio(@PathVariable("portfolioMemberId") Integer portfolioMemberId) {
		
		service.delPortfolioMemberById(portfolioMemberId);

		return "redirect:/portfolio";
	}
	
}
