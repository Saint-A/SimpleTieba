package DAO;

import org.hibernate.Session;

import Connection.HibernateSessionFactory;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		System.out.println("ªÒ»°session");
		return HibernateSessionFactory.getSession();
	}
	
	public void closeSession(){
		HibernateSessionFactory.closeSession();
	}
}