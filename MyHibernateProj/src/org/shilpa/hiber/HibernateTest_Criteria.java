package org.shilpa.hiber;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.shilpa.hiber.queries.UserDetails;


public class HibernateTest_Criteria {

	
	public static void main(String[] args) {
		String minUserId = "2";
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		//Criteria criteria = session.createCriteria(UserDetails.class);
		/*criteria.add(Restrictions.like("userName", "%User 1%"))
				.add(Restrictions.between("userId", 1, 123));
		*/
		//criteria.add(Restrictions.or(Restrictions.between("userId", 1, 3), Restrictions.between("userId", 7, 10)));
		
		//Criteria criteria = session.createCriteria(UserDetails.class).setProjection(Projections.property("userId")); // gets only user id. it is similar to select  userId from..
		
		//Criteria criteria = session.createCriteria(UserDetails.class).setProjection(Projections.max("userId")); 
		
		Criteria criteria = session.createCriteria(UserDetails.class)
									.addOrder(Order.desc("userId"));
		
		List<UserDetails> users =(List<UserDetails>) criteria.list();
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}
		
		
		
	}

}
