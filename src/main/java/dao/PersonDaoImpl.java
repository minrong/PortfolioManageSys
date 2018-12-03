package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Address;
import pojo.Broker;
import pojo.Investor;
import pojo.Person;
import pojoView.BrokerView;
import pojoView.InvestorView;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static Log logger = LogFactory.getLog(PersonDaoImpl.class);
	
	
	public void addAddress(Address ad,Integer personId) {
		Integer addressId = ad.getAddressId();
		logger.info("addressId："+addressId);
		try {
			Session session = sessionFactory.getCurrentSession();
			if (addressId == null) {
				ad.setPersonId(personId);
				session.save(ad);
			}else {
				session.update(ad);
			}
		}catch(Exception e){
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException("error addiing new address");
		}

	}

	public Address getAddressByPersonId(Integer personId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Address where personId = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, personId);
			Address ad = (Address) query.list().get(0);
			return ad;
		}catch(Exception e) {
			logger.info("操作失败："  + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}
	
	public void delAddressByPersonId(Integer personId) {
		try {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete Address ad where personId = ?0";
		Query query = session.createQuery(hql);
		query.setParameter(0, personId);
		query.executeUpdate();

		}catch(Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException("error addiing new address");
		}
	}



	public Integer addPerson(Person p) {
		Integer personId = p.getPersonId();
	try {
		Session session = sessionFactory.getCurrentSession();
		if(personId == null) {
			session.save(p);
			personId = p.getPersonId();
		}else {
			session.update(p);
		}
		return personId;
	}catch(Exception e){
		logger.info("操作失败：" + "在创建person时发生异常，" + e.getMessage() + ", " +e.getCause());
		throw new RuntimeException("error addiing new person");
	}
		
	}	
	
	public Investor getInvestorById(Integer personId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Investor iv = (Investor) session.get(Investor.class, personId);
			return iv;
		}catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
	}
	
	public Broker getBrokerById(Integer personId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Broker b = (Broker) session.get(Broker.class, personId);
			return b;
		}catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
	}
	
	public void delPersonById(Integer personId) {
		try {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete Person p where p.personId = ?0";
		Query query = session.createQuery(hql);
		query.setParameter(0, personId);
		query.executeUpdate();
		}catch(Exception e){
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}

	}

	public List<InvestorView> listInvestorView() {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<InvestorView> ivv = (List<InvestorView>)session.createQuery("from InvestorView").list();
		for(InvestorView iv:ivv) {
			System.out.println(iv.getPersonCode());
		}
		tx.commit();
		session.close();
		return ivv;
	}

	public List<BrokerView> listBrokerView() {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<BrokerView> bvw = (List<BrokerView>)session.createQuery("from BrokerView").list();
		for(BrokerView bv:bvw) {
			System.out.println(bv.getPersonCode());
		}
		tx.commit();
		session.close();
		return bvw;

	}

}
