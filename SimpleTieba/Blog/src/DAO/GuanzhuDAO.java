package DAO;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import bean.Guanzhu;

/**
 * A data access object (DAO) providing persistence and search support for
 * Guanzhu entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.DAO.Guanzhu
 * @author MyEclipse Persistence Tools
 */
public class GuanzhuDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(GuanzhuDAO.class);

	// property constants

	public void save(Guanzhu transientInstance) {
		log.debug("saving Guanzhu instance");
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

	public void delete(Guanzhu persistentInstance) {
		log.debug("deleting Guanzhu instance");
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

	public Guanzhu findById(int id) {
		log.debug("getting Guanzhu instance with id: " + id);
		try {
			Guanzhu instance = (Guanzhu) getSession()
					.get("bean.Guanzhu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}

	public List findexist(Guanzhu guanzhu){
		try{
			String queryString = "from Guanzhu as model where model."
					+ "user= ?and firendid=? and firendName=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, guanzhu.getUser());
			queryObject.setParameter(1, guanzhu.getFirendid());
			queryObject.setParameter(2, guanzhu.getFirendName());
			return queryObject.list();
		}catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}
	public List findByExample(Guanzhu instance) {
		log.debug("finding Guanzhu instance by example");
		try {
			List results = getSession().createCriteria("bean.Guanzhu")
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
		log.debug("finding Guanzhu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Guanzhu as model where model."
					+ propertyName + "= ?";
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

	public List findAll() {
		log.debug("finding all Guanzhu instances");
		try {
			String queryString = "from Guanzhu";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}

	public Guanzhu merge(Guanzhu detachedInstance) {
		log.debug("merging Guanzhu instance");
		try {
			Guanzhu result = (Guanzhu) getSession().merge(detachedInstance);
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

	public void attachDirty(Guanzhu instance) {
		log.debug("attaching dirty Guanzhu instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		finally{
			closeSession();
		}
	}

	public void attachClean(Guanzhu instance) {
		log.debug("attaching clean Guanzhu instance");
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