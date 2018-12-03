package dao;

import java.util.List;

import pojo.PortfolioMember;
import pojoView.PortfolioMemberView;


public interface PortfolioMemberDao{
	
	public void addPortfolioMember(PortfolioMember pm);
	
	public void delPortfolioMemberByAssetIdByPortfolioId(Integer assetId, Integer PortfolioId);
	
	
	public List<PortfolioMember> listPortfolioMemberByPortfolioId(Integer PortfolioId);
	
	public List<PortfolioMemberView> listPortfolioMemberViewByPortfolioId(Integer pid);
	
	public PortfolioMember getPortfolioMemberById(Integer pid);
	
	public void delPortfolioMemberById(Integer PortfolioMemberId);
	
}


