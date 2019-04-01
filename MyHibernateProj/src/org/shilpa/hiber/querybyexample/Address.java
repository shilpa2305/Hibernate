package org.shilpa.hiber.querybyexample;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="address_querybyexample")
public class Address {
	@Id
	private long id; 
	private String city ;
	private String street;
	private String countryISO2Code;
	@Embedded
	private AddressType addressType;
	
	
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountryISO2Code() {
		return countryISO2Code;
	}
	public void setCountryISO2Code(String countryISO2Code) {
		this.countryISO2Code = countryISO2Code;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
