package org.shilpa.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shilpa.hiber.dto.manytomany.UserDetails2;
import org.shilpa.hiber.dto.manytomany.Vehicle;

public class HibernateTest_manytomany {

	public static void main(String[] args) {
		UserDetails2 user = new UserDetails2();
		user.setUserName("Ramesh");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jet");
		
		//user renting multple vehicles
		user.getVehicles().add(vehicle1);
		user.getVehicles().add(vehicle2);
		
		
		vehicle1.getUsers().add(user);
		vehicle2.getUsers().add(user);
		
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
