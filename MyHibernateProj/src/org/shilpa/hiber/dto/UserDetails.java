package org.shilpa.hiber.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity //(name="userdetails")
@Table(name="userdetails")
public class UserDetails {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	//@EmbeddedId
	//private LoginName id;
	//@Basic
	//@Transient
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	@Lob
	private String description;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="city",column=@Column(name="city_name")),
	@AttributeOverride(name="state",column=@Column(name="state_name")),
	@AttributeOverride(name="street",column=@Column(name="street_name"))
	})
	private Address address;
	
	@ElementCollection
	@JoinTable(   name="collection_table",
			      joinColumns=@JoinColumn(name="USER_ID")
	)
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@CollectionId(columns={@Column(name="address_id")},generator="hilo-gen",type=@Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<>();
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="user_name")
	public String getUserName() {
		return userName + " getter it is";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
