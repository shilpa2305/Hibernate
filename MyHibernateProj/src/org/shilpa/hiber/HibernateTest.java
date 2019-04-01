package org.shilpa.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shilpa.hiber.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(4);
		userDetails.setUserName("Fourth User");
		
		//only one session factory object per application. creates and handles
		//all sessions through out the execution. get the session object from this
		//session factory and use it to save data. hibernate.cfg.xml -- this file has the session factory details.
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//begin a transaction (single unit of work) to persist data
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		

	}

}
