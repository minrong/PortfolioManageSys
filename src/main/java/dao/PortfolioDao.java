package dao;

import java.util.List;

import pojo.Asset;
import pojo.Portfolio;
import pojoView.PortfolioView;

public interface PortfolioDao {

	public void addPortfolio(Portfolio p);
	
	public void delPortfolioById(int pid);
	
	public void UpdatePortfolio(Integer pid, String portfolioCode, Integer beneficiaryId, Integer managerId);

	public PortfolioView getPortfolioViewById(int pid);

	public List<PortfolioView> listPortfolioView();
	
	public List<Portfolio> listPortfolioByOwnerId(int personId);
	
	public List<Portfolio> listPortfolioByBeneficiaryId(int personId);
	
	public List<Portfolio> listPortfolioByManagerId(int personId);
	
	public Portfolio getPortfolioById(Integer pid);
	
}
