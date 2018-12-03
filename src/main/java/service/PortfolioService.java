package service;


import java.util.List;

import pojo.Address;
import pojo.Asset;
import pojo.Broker;
import pojo.DepositAccount;
import pojo.Investor;
import pojo.Portfolio;
import pojo.PortfolioMember;
import pojo.PrivateInvestment;
import pojo.Stock;
import pojoView.BrokerView;
import pojoView.DepositAccountView;
import pojoView.InvestorView;
import pojoView.PortfolioMemberView;
import pojoView.PortfolioView;
import pojoView.PrivateInvestmentView;
import pojoView.StockView;


public interface PortfolioService {
	
	public void addInvestor(Investor iv, Address ad);
	
	public void delInvestorById(Integer id);
	
	public Investor getInvestorById(Integer personId);
	
	public Broker getBrokerById(Integer personId);
	
	public Address getAddressByPersonId(Integer personId);
	
	public void addBroker(Broker b,Address ad);

	public void delBrokerById(Integer personId);

	
	
	public void addPortfolio(Portfolio p);
	
	public void delPortfolioById(Integer pid);
	
	
	public PortfolioView getPortfolioViewById(Integer pid);
	
	public void addPortfolioMember(PortfolioMember pm);

	
	public List<PortfolioMemberView> getPortfolioMemberViewByPortfolioId(Integer pid);
	
	public void addStock(Stock s);
	
	public void addDepositAccount(DepositAccount d);
	
	public void addPrivateInvestment(PrivateInvestment p);
	
	public void delAssetById(Integer assetId);

	public List<StockView> listStockView();
	
	public List<PrivateInvestmentView> listPrivateInvestmentView();
	
	public List<DepositAccountView> listDepositAccountView();
	
	public List<PortfolioView> listPortfolioView();
	
	public List<BrokerView> listBrokerView();
	
	public List<InvestorView> listInvestorView();
	
	public DepositAccount getDepositAccountById(Integer assetId);
	
	public Stock getStockById(Integer assetId);
	
	public PrivateInvestment getPrivateInvestmentById(Integer assetId);
	
	public Portfolio getPortfolioById(Integer pid);
	
	public PortfolioMember getPortfolioMemberById(Integer pid);
	
	public Asset getAssetById(Integer assetId);
	
	public void delPortfolioMemberById(Integer PortfolioMemberId);
}
