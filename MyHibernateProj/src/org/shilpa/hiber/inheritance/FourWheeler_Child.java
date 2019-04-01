package org.shilpa.hiber.inheritance;

import javax.persistence.Entity;

@Entity
public class FourWheeler_Child extends FourWheeler {
	private String child_attrib;

	public String getChild_attrib() {
		return child_attrib;
	}

	public void setChild_attrib(String child_attrib) {
		this.child_attrib = child_attrib;
	}
	 
	
}
