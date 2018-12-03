package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Asset;
import pojo.DepositAccount;
import pojo.PrivateInvestment;
import pojo.Stock;
import pojoView.DepositAccountView;
import pojoView.PrivateInvestmentView;
import pojoView.StockView;

@Repository
public class AssetDaoImpl implements AssetDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static Log logger = LogFactory.getLog(AssetDaoImpl.class);
	

	public void addStock(Stock s) {
		Integer assetId = s.getAssetId();
		try {
			Session session = sessionFactory.getCurrentSession();
			if(assetId == null) {
				session.save(s);
			}else {
				session.update(s);
			}
		}catch(Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}

	public void addDepositAccount(DepositAccount d) {
		Integer assetId = d.getAssetId();
		try {
			Session session = sessionFactory.getCurrentSession();
			if(assetId == null) {
				session.save(d);
			}else {
				session.update(d);
			}
		}catch(Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
		
	}

	public void addPrivateInvestment(PrivateInvestment p) {
		Integer assetId = p.getAssetId();
		try {
			Session session = sessionFactory.getCurrentSession();
			if(assetId == null) {
				session.save(p);
			}else {
				session.update(p);
			}
		}catch(Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
		
	}

	public void delAssetById(int assetId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "delete Asset where assetId = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, assetId);
			query.executeUpdate();
		}catch(Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}


	public List<StockView> listStockView() {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from StockView";
			Query query = session.createQuery(hql);
			List<StockView> sv = query.list();
			return sv;
		}catch(Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}


	public List<DepositAccountView> listDepositAccountView() {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from DepositAccountView";
			Query query = session.createQuery(hql);
			List<DepositAccountView> dav = query.list();
			return dav;
		}catch(Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}

	public List<PrivateInvestmentView> listPrivateInvestmentView() {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from PrivateInvestmentView";
			Query query = session.createQuery(hql);
			List<PrivateInvestmentView> piv = query.list();
			return piv;
		}catch(Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}
	
	public DepositAccount getDepositAccountById(Integer assetId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Asset where assetId = ?0 and accountType = 'D' ";
			Query query = session.createQuery(hql);
			query.setParameter(0, assetId);
			DepositAccount d = (DepositAccount) query.list().get(0);
			return d;
		}catch(Exception e) {
			logger.info("操作失败："  + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}
	
	public Stock getStockById(Integer assetId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Asset where assetId = ?0 and accountType = 'S' ";
			Query query = session.createQuery(hql);
			query.setParameter(0, assetId);
			Stock s = (Stock) query.list().get(0);
			return s;
		}catch(Exception e) {
			logger.info("操作失败："  + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}
	
	public PrivateInvestment getPrivateInvestmentById(Integer assetId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Asset where assetId = ?0 and accountType = 'P' ";
			Query query = session.createQuery(hql);
			query.setParameter(0, assetId);
			PrivateInvestment p = (PrivateInvestment) query.list().get(0);
			return p;
		}catch(Exception e) {
			logger.info("操作失败："  + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}
	

	public Asset getAssetById(Integer assetId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Asset where assetId = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, assetId);
			Asset a = (Asset) query.list().get(0);
			return a;
		}catch(Exception e) {
			logger.info("操作失败："  + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}
	

	

}
