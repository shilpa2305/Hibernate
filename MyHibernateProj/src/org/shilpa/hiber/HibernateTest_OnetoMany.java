package org.shilpa.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shilpa.hiber.dto.UserDetails;
import org.shilpa.hiber.dto.onetomany.UserDetails2;
import org.shilpa.hiber.dto.onetomany.Vehicle;

public class HibernateTest_OnetoMany {

	public static void main(String[] args) {
		UserDetails2 user = new UserDetails2();
		user.setUserName("Ramesh");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jet");
		
		user.getVehicles().add(vehicle1);
		user.getVehicles().add(vehicle2);
		
		//use the below two lines for manytoone
		vehicle1.setUserDetails2(user);
		vehicle2.setUserDetails2(user);
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}
}
