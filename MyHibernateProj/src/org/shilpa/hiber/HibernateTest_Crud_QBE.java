package org.shilpa.hiber;

import java.util.List;

import org.hibernate.PropertyNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shilpa.hiber.dto.crud.UserDetails;
import org.shilpa.hiber.querybyexample.Address;
import org.shilpa.hiber.querybyexample.AddressType;


public class HibernateTest_Crud_QBE {

	private void listAddresses(List<Address> addresses) {
		  for (Address address : addresses) {
		    System.out.println(address.getId() + ", " +
		      address.getCountryISO2Code() + ", " +
		      address.getCity() + ", " + 
		      address.getStreet() + ", " +
		      address.getAddressType().getType() + ", " +
		      address.getAddressType().getDescription());
		  }
		}
	
	
	public static void main(String[] args) {
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		AddressType[] addressTypes = new AddressType[5];
		addressTypes[0].setType(1);
		addressTypes[0].setDescription("Shipper");
		addressTypes[1].setType(2);
		addressTypes[1].setDescription("Consignee");
		addressTypes[2].setType(4);
		addressTypes[2].setDescription("Delivery");
		addressTypes[3].setType(5);
		addressTypes[3].setDescription("Bill to");
		addressTypes[4].setType(6);
		addressTypes[4].setDescription("Customer");
		
		Address[] address = new Address[5];
		address[0].setId(75);
		address[0].setCountryISO2Code("US"); 
		address[0].setCity("CHICAGO"); 
		address[0].setStreet("Los Angeles Way2"); 
		address[0].setAddressType(addressTypes[4]);
	
	
		address[1].setId(170);
		address[1].setCountryISO2Code("US"); 
		address[1].setCity("CHICAGO"); 
		address[1].setStreet("Jackson Blvd 33a"); 
		address[1].setAddressType(addressTypes[2]);
		
		address[2].setId(63);
		address[2].setCountryISO2Code("US"); 
		address[2].setCity("CHICAGO"); 
		address[2].setStreet(" Main Avenue 1"); 
		address[2].setAddressType(addressTypes[3]);
	
		address[3].setId(37);
		address[3].setCountryISO2Code("US"); 
		address[3].setCity("CHICAGO"); 
		address[3].setStreet("Jackson Blvd 33a"); 
		address[3].setAddressType(addressTypes[2]);
		
		address[4].setId(36);
		address[4].setCountryISO2Code("US"); 
		address[4].setCity("CHICAGO"); 
		address[4].setStreet("Jackson Blvd 33a"); 
		address[4].setAddressType(addressTypes[2]);
		
		address[5].setId(154);
		address[5].setCountryISO2Code("GR"); 
		address[5].setCity("ATHENS"); 
		address[5].setStreet("BETA ALPHA Street 5"); 
		address[5].setAddressType(addressTypes[1]);
		
		address[6].setId(83);
		address[6].setCountryISO2Code("US"); 
		address[6].setCity("ATLANTA"); 
		address[6].setStreet(null); 
		address[6].setAddressType(addressTypes[4]);
	
		  
		address[7].setId(25);
		address[7].setCountryISO2Code("US"); 
		address[7].setCity("ATLANTA"); 
		address[7].setStreet(null); 
		address[7].setAddressType(addressTypes[0]);
		
		address[8].setId(184);
		address[8].setCountryISO2Code("US"); 
		address[8].setCity("ATLANTA"); 
		address[8].setStreet(null); 
		address[8].setAddressType(addressTypes[0]);
		
		address[9].setId(84);
		address[9].setCountryISO2Code("US"); 
		address[9].setCity("BOSTON"); 
		address[9].setStreet(null); 
		address[9].setAddressType(addressTypes[4]);
		
		address[10].setId(82);
		address[10].setCountryISO2Code("US"); 
		address[10].setCity("SAN FRANCISCO"); 
		address[10].setStreet(null); 
		address[10].setAddressType(addressTypes[4]);
		
		address[11].setId(75);
		address[11].setCountryISO2Code("US"); 
		address[11].setCity("CHICAGO"); 
		address[11].setStreet("Los Angeles Way2"); 
		address[11].setAddressType(addressTypes[4]);
		
		
		session.save(address[0]);
		session.save(address[1]);
		session.save(address[2]);
		session.save(address[3]);
		session.save(address[4]);
		session.save(address[5]);
		session.save(address[6]);
		session.save(address[7]);
		session.save(address[8]);
		session.save(address[9]);
		session.save(address[10]);
		session.save(address[11]);
		}catch (PropertyNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		 
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
