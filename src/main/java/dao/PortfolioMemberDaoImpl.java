package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.PortfolioMember;
import pojoView.PortfolioMemberView;

@Repository
public class PortfolioMemberDaoImpl implements PortfolioMemberDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static Log logger = LogFactory.getLog(PortfolioMemberDaoImpl.class);
	
	public void addPortfolioMember(PortfolioMember pm) {
		Integer portfolioMemberId = pm.getPortfolioMemberId();
		try {
			Session session = sessionFactory.getCurrentSession();
			if (portfolioMemberId == null) {
				session.save(pm);
			}else {
				session.update(pm);
			}
		}catch(Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
		
	}

	public void delPortfolioMemberByAssetIdByPortfolioId(Integer assetId, Integer PortfolioId) {
		try {
			logger.info("in portfolioMember class,assetId："+assetId + " PortfolioId: "+ PortfolioId );
			Session session = sessionFactory.getCurrentSession();
			PortfolioMember pm = new PortfolioMember();
			Query query;
			String hql;
			if (assetId == null) {
				hql = "delete PortfolioMember pm where pm.portfolioId=?0";
				query = session.createQuery(hql);
				query.setParameter(0, PortfolioId);
			} else if (PortfolioId == null) {
				hql = "delete PortfolioMember pm where pm.assetId=?0";
				query = session.createQuery(hql);
				query.setParameter(0, assetId);
			} else {
				hql = "delete PortfolioMember pm where pm.assetId=?0 and pm.portfolioId=?1";
				query = session.createQuery(hql);
				query.setParameter(0, assetId).setParameter(1, PortfolioId);
			}
			query.executeUpdate();
		} catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
		
	}
	
	public void delPortfolioMemberById(Integer PortfolioMemberId) {
		try {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete PortfolioMember p where p.portfolioMemberId = ?0";
		Query query = session.createQuery(hql);
		query.setParameter(0, PortfolioMemberId);
		query.executeUpdate();
		
		}catch(Exception e){
			logger.info("操作失败：" + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}


	
	public List<PortfolioMemberView> listPortfolioMemberViewByPortfolioId(Integer pid){
		System.out.print(pid);
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from PortfolioMemberView pv where pv.portfolioId=:pid";
			Query query = session.createQuery(hql);
			query.setParameter("pid", pid);
			List<PortfolioMemberView> pmvl = query.list();
			for(PortfolioMemberView pv: pmvl){
				System.out.print(pv.getAssetCode());
			}
			return pmvl;
		}catch(Exception e){
			logger.info("操作失败："  + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
		
	}

	
	public List<PortfolioMember> listPortfolioMemberByPortfolioId(Integer PortfolioId) {
		try {
		Session session = sessionFactory.getCurrentSession();
		List<PortfolioMember> pp = (List<PortfolioMember>)session.createQuery("from PortfolioMember").list();
		List<PortfolioMember> returnP = new ArrayList<PortfolioMember>();
		for(PortfolioMember p:pp) {
			System.out.println(p.getAssetId());
		}		
		return returnP;
		}catch(Exception e) {
			logger.info("操作失败："  + e.getMessage() + ", " +e.getCause());
			throw new RuntimeException();
		}
	}
	
	public PortfolioMember getPortfolioMemberById(Integer pid) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from PortfolioMember p where p.portfolioMemberId = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, pid);
			PortfolioMember p = (PortfolioMember) query.list().get(0);
			return p;
		} catch (Exception e) {
			logger.info("操作失败：" + e.getMessage() + ", " + e.getCause());
			throw new RuntimeException();
		}
	}
	

}
