package org.shilpa.hiber.dto.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

//OneToOne one user can have only one vehicle
@Entity
public class Vehicle {
	@Id
	@GenericGenerator(name="my-gen",strategy="sequence")
	private int vehicleId;
	private String vehicleName;
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
