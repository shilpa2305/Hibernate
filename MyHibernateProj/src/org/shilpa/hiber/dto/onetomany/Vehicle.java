package org.shilpa.hiber.dto.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

//OneToOne one user can have only one vehicle
@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	//use vehicle obj to find users
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE) //donot throw exception if user data for vehicle is not found
	private UserDetails2 userDetails2;
	
	
	
	public UserDetails2 getUserDetails2() {
		return userDetails2;
	}
	public void setUserDetails2(UserDetails2 userDetails2) {
		this.userDetails2 = userDetails2;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
