package org.shilpa.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shilpa.hiber.dto.crud.UserDetails;


public class HibernateTest_Crud {

	
	public static void main(String[] args) {
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 1; i <=10; i++) {
			UserDetails userDetails = new UserDetails();
			userDetails.setUserName("User " + i);
			session.save(userDetails);
			
		}
		
		/*UserDetails userDetails = (UserDetails)session.get(UserDetails.class,6);
		session.delete(userDetails);
		
		UserDetails userDetails2 = (UserDetails)session.get(UserDetails.class,5);
		userDetails2.setUserName("new userName");
		session.update(userDetails2);*/
		session.getTransaction().commit();
		session.close();
		
		//System.out.println(userDetails.getUserName()); // proxy eager fetch for member variables so can access oitside session
	}

}
