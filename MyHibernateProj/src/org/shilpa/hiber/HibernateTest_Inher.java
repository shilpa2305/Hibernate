package org.shilpa.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shilpa.hiber.dto.UserDetails;
import org.shilpa.hiber.inheritance.FourWheeler;
import org.shilpa.hiber.inheritance.FourWheeler_Child;
import org.shilpa.hiber.inheritance.TwoWheeler;
import org.shilpa.hiber.inheritance.Vehicle;

public class HibernateTest_Inher {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike steeringHandle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche steeringWheel");
		
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//begin a transaction (single unit of work) to persist data
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		//session.save(child);
		session.getTransaction().commit();
		

	}

}
