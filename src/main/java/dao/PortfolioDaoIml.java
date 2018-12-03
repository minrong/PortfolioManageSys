package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Asset;
import pojo.Portfolio;
import pojoView.InvestorView;
import pojoView.PortfolioView;

@Repository
public class PortfolioDaoIml implements PortfolioDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static Log logger = LogFactory.getLog(PortfolioDaoIml.class);
	
	public void addPortfolio(Portfolio p) {
		Integer portfolioId = p.getPortfolioId();
		try {
			Session session = sessionFactory.getCurrentSession();
			if (portfolioId == null) {
				session.save(p);
			}else {
				session.update(p);
			}
		}catch(Exception e){
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}

	public void delPortfolioById(int pid) {
		try {
			Session session = sessionFactory.getCurrentSession();
			System.out.println("delete portfolio " + pid);
			Query query = session.createQuery("delete Portfolio p where p.portfolioId = ?0");
			query.setParameter(0, pid);
			query.executeUpdate();
		} catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}		
	}

	public void UpdatePortfolio(Integer pid, String portfolioCode, Integer beneficiaryId, Integer managerId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Portfolio p = (Portfolio) session.load(Portfolio.class, pid);
			System.out.println(beneficiaryId);
			Integer zero = 0;
			if (beneficiaryId != zero) {
				p.setBeneficiaryId(beneficiaryId);
			}
			if (managerId != zero) {
				p.setManagerId(managerId);
			}
			if (portfolioCode != null) {
				p.setPortfolioCode(portfolioCode);
			}
			session.update(p);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("操作失败：UpdatePortfolio" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}

		
	}

	public PortfolioView getPortfolioViewById(int pid) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from PortfolioView p where p.portfolioId = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, pid);
			PortfolioView pp = (PortfolioView) query.list().get(0);
			return pp;
		} catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
		
	}

	public List<PortfolioView> listPortfolioView() {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from PortfolioView";
			Query query = session.createQuery(hql);
			List<PortfolioView> pp = query.list();
			return pp;
		} catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
	}

	public List<Portfolio> listPortfolioByOwnerId(int personId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Portfolio p where p.ownerId = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, personId);
			List<Portfolio> pp = query.list();
			System.out.println("listPortfolioOwn");
			for (Portfolio p:pp) {
				System.out.println(p.getPortfolioId());
			}
			return pp;
		} catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}

	}
	
	public List<Portfolio> listPortfolioByBeneficiaryId(int personId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Portfolio p where p.beneficiaryId = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, personId);
			List<Portfolio> pp = query.list();
			System.out.println("listPortfolioBenefit");
			for (Portfolio p:pp) {
				System.out.println(p.getPortfolioId());
			}
			return pp;
		} catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
	}
	
	public List<Portfolio> listPortfolioByManagerId(int personId){
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Portfolio p where p.managerId = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, personId);
			List<Portfolio> pp = query.list();
			for (Portfolio p:pp) {
				System.out.println(p.getPortfolioId());
			}
			return pp;
		} catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
		
	}
	
	public Portfolio getPortfolioById(Integer pid) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Portfolio p where p.portfolioId = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, pid);
			Portfolio p = (Portfolio) query.list().get(0);
			return p;
		} catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
		
	}

}
