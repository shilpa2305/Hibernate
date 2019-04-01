package org.shilpa.hiber.dto.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

//OneToOne one user can have only one vehicle
@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	//use vehicle obj to find users
	@ManyToMany(mappedBy="vehicles")
	private Collection<UserDetails2> users = new ArrayList<UserDetails2>();
	
	

	public Collection<UserDetails2> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserDetails2> users) {
		this.users = users;
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
