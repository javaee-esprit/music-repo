package org.esprit.javaee.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
public class Member extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String firstname;
	private String lastname;
	private Address address;
	private List<Rating> ratings;

	public Member() {
	}   
	
	public Member(String login, String password, String firstname,
			String lastname, Address address) {
		super(login, password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}



	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToMany(mappedBy="member",cascade=CascadeType.REMOVE)
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
   
}
