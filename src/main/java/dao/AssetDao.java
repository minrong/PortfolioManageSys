package dao;

import java.util.List;

import pojo.Asset;
import pojo.DepositAccount;
import pojo.PrivateInvestment;
import pojo.Stock;
import pojoView.DepositAccountView;
import pojoView.PrivateInvestmentView;
import pojoView.StockView;

public interface AssetDao {

	
	public void addStock(Stock s);
	
	public void addDepositAccount(DepositAccount d);
	
	public void addPrivateInvestment(PrivateInvestment p);
	
	public void delAssetById(int assetId);
	
	public List<StockView> listStockView();
	
	public List<DepositAccountView> listDepositAccountView();
	
	public List<PrivateInvestmentView> listPrivateInvestmentView();
		
	public DepositAccount getDepositAccountById(Integer assetId);
	
	public Stock getStockById(Integer assetId);
	
	public PrivateInvestment getPrivateInvestmentById(Integer assetId);
	
	public Asset getAssetById(Integer assetId);
}
