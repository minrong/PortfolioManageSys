package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.AssetDao;
import dao.PersonDao;
import dao.PortfolioDao;
import dao.PortfolioMemberDao;
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


@Service
public class ServiceImpl implements PortfolioService {
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private PortfolioDao portfolioDao;
	
	@Autowired
	private PortfolioMemberDao portfolioMemberDao;
	
	@Autowired
	private AssetDao assetDao;

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void addInvestor(Investor p, Address ad) {
		
		Integer personId = personDao.addPerson(p);
		personDao.addAddress(ad,personId);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void delInvestorById(Integer id) {
	   	List<Portfolio> p = portfolioDao.listPortfolioByOwnerId(id);
	   	for(Portfolio pi: p) {
	   		portfolioDao.delPortfolioById(pi.getPortfolioId());
		   	List<PortfolioMember> pm = portfolioMemberDao.listPortfolioMemberByPortfolioId(pi.getPortfolioId());
		   	for(PortfolioMember m:pm) {
		   		System.out.print("related portfolioMember "+ m.getPortfolioMemberId());
		   		portfolioMemberDao.delPortfolioMemberByAssetIdByPortfolioId(m.getAssetId(), m.getPortfolioId());
		   	}
	   	}
	   	List<Portfolio> b = portfolioDao.listPortfolioByBeneficiaryId(id);
	   	for(Portfolio pb: b) {
	   		System.out.println(pb.getPortfolioId());
	   		Integer zero = 0;
	   		portfolioDao.UpdatePortfolio(pb.getPortfolioId(), null, null, zero);
	   	}
	   	personDao.delPersonById(id);
	   	personDao.delAddressByPersonId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public Investor getInvestorById(Integer personId) {
		return personDao.getInvestorById(personId);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public Broker getBrokerById(Integer personId) {
		return personDao.getBrokerById(personId);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void addBroker(Broker b,Address ad) {
		Integer personId = personDao.addPerson(b);
		personDao.addAddress(ad,personId);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void delBrokerById(Integer personId) {
		List<Portfolio> p = portfolioDao.listPortfolioByManagerId(personId);
		if (p.isEmpty()) {
		   	personDao.delPersonById(personId);
		   	personDao.delAddressByPersonId(personId);
		}else {
			System.out.println("manager still managing following portfolio(s), pls assign other manager before deleting this manager");
			for (Portfolio pp:p) {
				System.out.println(pp.getPortfolioCode());
			}
		}
	}

	
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public Address getAddressByPersonId(Integer personId) {
		return personDao.getAddressByPersonId(personId);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void addPortfolio(Portfolio p) {
		portfolioDao.addPortfolio(p);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void delPortfolioById(Integer pid) {
		portfolioMemberDao.delPortfolioMemberByAssetIdByPortfolioId(null, pid);
		portfolioDao.delPortfolioById(pid);
	};
	

	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public PortfolioView getPortfolioViewById(Integer pid) {
		PortfolioView pv = portfolioDao.getPortfolioViewById(pid);
		return pv;
		
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void addPortfolioMember(PortfolioMember pm) {
		portfolioMemberDao.addPortfolioMember(pm);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public List<PortfolioMemberView> getPortfolioMemberViewByPortfolioId(Integer pid){
		List<PortfolioMemberView> pmvl = portfolioMemberDao.listPortfolioMemberViewByPortfolioId(pid);
		return pmvl;
	}
	

	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void addStock(Stock s) {
		assetDao.addStock(s);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void addDepositAccount(DepositAccount d) {
		assetDao.addDepositAccount(d);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void addPrivateInvestment(PrivateInvestment p) {
		assetDao.addPrivateInvestment(p);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void delAssetById(Integer assetId) {
		portfolioMemberDao.delPortfolioMemberByAssetIdByPortfolioId(assetId, null);
		assetDao.delAssetById(assetId);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public List<StockView> listStockView(){
		return assetDao.listStockView();
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public List<PrivateInvestmentView> listPrivateInvestmentView(){
		return assetDao.listPrivateInvestmentView();
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public List<DepositAccountView> listDepositAccountView(){
		return assetDao.listDepositAccountView();
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public List<PortfolioView> listPortfolioView(){
		return portfolioDao.listPortfolioView();
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public List<BrokerView> listBrokerView(){
		return personDao.listBrokerView();
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public List<InvestorView> listInvestorView(){
		return personDao.listInvestorView();
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public DepositAccount getDepositAccountById(Integer assetId) {
		return assetDao.getDepositAccountById(assetId);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public Stock getStockById(Integer assetId) {
		return assetDao.getStockById(assetId);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public PrivateInvestment getPrivateInvestmentById(Integer assetId) {
		return assetDao.getPrivateInvestmentById(assetId);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public Portfolio getPortfolioById(Integer pid) {
		return portfolioDao.getPortfolioById(pid);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public PortfolioMember getPortfolioMemberById(Integer pid) {
		return portfolioMemberDao.getPortfolioMemberById(pid);
		
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public Asset getAssetById(Integer assetId) {
		return assetDao.getAssetById(assetId);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Throwable.class)
	public void delPortfolioMemberById(Integer PortfolioMemberId) {
		portfolioMemberDao.delPortfolioMemberById(PortfolioMemberId);
	}
	
}
