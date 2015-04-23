package org.esprit.javaee.persistence;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

@Entity
public class Admin extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer adminLevel;

	public Admin() {
	}   
	
	
	
	public Admin(String login, String password, Integer adminLevel) {
		super(login, password);
		this.adminLevel = adminLevel;
	}



	public Integer getAdminLevel() {
		return this.adminLevel;
	}

	public void setAdminLevel(Integer adminLevel) {
		this.adminLevel = adminLevel;
	}
   
}
