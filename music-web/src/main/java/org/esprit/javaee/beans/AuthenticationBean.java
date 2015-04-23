package org.esprit.javaee.beans;

import javax.ejb.EJB;

import org.esprit.javaee.persistence.User;
import org.esprit.javaee.services.interfaces.UserServiceLocal;

public class AuthenticationBean {
	
	private UserServiceLocal userServiceLocal;
	
	private String login;
	private String password;
	
	public AuthenticationBean(UserServiceLocal userServiceLocal, String login,
			String password) {
		this.userServiceLocal = userServiceLocal;
		this.login = login;
		this.password = password;
	}

	public String doLogin(){
		String navigateTo = null;
		User found = userServiceLocal.authenticate(login, password);
		if (found != null) {
			navigateTo = "/home.html";
		} else {
			navigateTo = "/login.html";
		}
		return navigateTo;
	}

}
