package org.shilpa.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shilpa.hiber.dto.UserDetails;
import org.shilpa.hiber.dto.onetoone.UserDetails2;
import org.shilpa.hiber.dto.onetoone.Vehicle;

public class HibernateTest_OnetoOne {

	public static void main(String[] args) {
		UserDetails2 user = new UserDetails2();
		user.setUserName("Ramesh");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		user.setVehicle(vehicle);
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}
}
