package org.shilpa.hiber;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shilpa.hiber.queries.UserDetails;


public class HibernateTest_NamedQuery {

	
	public static void main(String[] args) {
		String minUserId = "2";
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Query query = session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, Integer.parseInt(minUserId));
		List<UserDetails> users =(List<UserDetails>) query.list();
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "User 9");
		users =(List<UserDetails>) query.list();
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}
		
	}

}
