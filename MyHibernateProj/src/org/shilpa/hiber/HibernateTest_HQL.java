package org.shilpa.hiber;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shilpa.hiber.dto.crud.UserDetails;


public class HibernateTest_HQL {

	
	public static void main(String[] args) {
		String minUserId = "5";
		String userName = "User 10";
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		//Query query = session.createQuery("from UserDetails");
		//Query query = session.createQuery("select userId from UserDetails");
		//Query query = session.createQuery("select max(userId) from UserDetails");
		//Query query = session.createQuery("select new map(userId,userName) from UserDetails");
		//The below query works fine but it might lead to sqlinjection sqlinjection. Plus
		//if its an user input then it might give inconsistent values. say, String minUserId = "5 OR 1=1"
		//Query query = session.createQuery("from UserDetails where userId > "+minUserId); 
		Query query = session.createQuery("from UserDetails where userId > ? and userName = ?");
		query.setInteger(0, Integer.parseInt(minUserId));	
		query.setString(1, userName);
		
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<UserDetails> users =(List<UserDetails>) query.list();
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}
	}

}
