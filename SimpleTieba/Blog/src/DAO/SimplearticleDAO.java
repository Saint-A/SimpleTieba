package DAO;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import bean.Simplearticle;

/**
 * A data access object (DAO) providing persistence and search support for
 * Simplearticle entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.DAO.Simplearticle
 * @author MyEclipse Persistence Tools
 */
public class SimplearticleDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(SimplearticleDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String INTRODUTION = "introdution";

	public void save(Simplearticle transientInstance) {
		log.debug("saving Simplearticle instance");
		try {
			
			Transaction tx=getSession().beginTransaction();
			getSession().save(transientInstance);
			tx.commit();
	
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}
	public void update(Simplearticle transientInstance){
		log.debug("update Simplearticle instance");
		try {
			
			Transaction tx=getSession().beginTransaction();
			getSession().update(transientInstance);
			tx.commit();
	
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}
	public void delete(Simplearticle persistentInstance) {
		log.debug("deleting Simplearticle instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}

	public Simplearticle findById(java.lang.Integer id) {
		log.debug("getting Simplearticle instance with id: " + id);
		System.out.println(id);
		try {
			Simplearticle instance = (Simplearticle) getSession().get(
					"bean.Simplearticle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}

	public List findByExample(Simplearticle instance) {
		log.debug("finding Simplearticle instance by example");
		try {
			List results = getSession().createCriteria("com.DAO.Simplearticle")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Simplearticle instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Simplearticle as model where model."
					+ propertyName + "= ?"+"order by updateTime desc, articleId desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByIntrodution(Object introdution) {
		return findByProperty(INTRODUTION, introdution);
	}

	public List findAll() {
		log.debug("finding all Simplearticle instances");
		try {
			String queryString = "from Simplearticle order by updateTime desc, articleId desc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			closeSession();
		}
	}

	public Simplearticle merge(Simplearticle detachedInstance) {
		log.debug("merging Simplearticle instance");
		try {
			Simplearticle result = (Simplearticle) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}

	public void attachDirty(Simplearticle instance) {
		log.debug("attaching dirty Simplearticle instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}

	public void attachClean(Simplearticle instance) {
		log.debug("attaching clean Simplearticle instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}
}