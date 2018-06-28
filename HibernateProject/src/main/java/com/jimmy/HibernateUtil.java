package com.jimmy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static final SessionFactory buildSessionFactory() {
    	   try {
    		   
    		   return new Configuration().configure().buildSessionFactory();
    		  
    	   }  catch (Throwable ex) {
    		   System.out.println("Initial SessionFactory failed."+ex);
    		   throw new ExceptionInInitializerError(ex);
  
    		   
    	   }
    	
    }
    
    public static SessionFactory getSessionFactory() {
    	 return sessionFactory;
    	
    	
    }
	
	
}
