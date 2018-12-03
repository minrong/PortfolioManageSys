package dao;

import java.util.List;
import pojo.Address;
import pojo.Broker;
import pojo.Investor;
import pojo.Person;
import pojoView.BrokerView;
import pojoView.InvestorView;

public interface PersonDao {
	
	public void addAddress(Address ad,Integer personId);
	
	public void delAddressByPersonId(Integer personId);
	
	public Address getAddressByPersonId(Integer personId);
		
	public Integer addPerson(Person p);
	
	public Investor getInvestorById(Integer personId);
	
	public Broker getBrokerById(Integer personId);
	
	public void delPersonById(Integer personId);
	
	public List<InvestorView> listInvestorView();
	
	public List<BrokerView> listBrokerView();
	

}
