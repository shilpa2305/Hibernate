package org.shilpa.hiber.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
//@DiscriminatorValue("Bike") -- use for single table strategy 
public class TwoWheeler extends Vehicle{
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
}
