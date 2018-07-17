package Connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactory {

 
	private static  ThreadLocal session = new ThreadLocal();
    private static SessionFactory sessionFactory;
	
    

    static{
    	System.out.println("创建工厂");
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
		System.out.println(configuration);
		sessionFactory = configuration.buildSessionFactory();
    }
	

   
    
    public static Session getSession(){
    	System.out.println("获取session");
        Session s = (Session) session.get();
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}

        return s;
    }

    public static void closeSession() {
        Session s = (Session) session.get();
        if (s != null) {
            s.close();
            session.set(null);
        }
    }


}