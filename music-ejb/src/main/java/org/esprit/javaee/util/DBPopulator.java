package org.esprit.javaee.util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.esprit.javaee.persistence.Admin;
import org.esprit.javaee.persistence.Member;
import org.esprit.javaee.services.impl.UserService;
import org.esprit.javaee.services.interfaces.UserServiceLocal;

@Singleton
@Startup
public class DBPopulator {
	
	@EJB
	private UserServiceLocal userService;
	
	public DBPopulator() {
	}
	
	@PostConstruct
	public void createSomeUsers(){
		if (!userService.isLoginInUse("root")) {
			userService.create(new Admin("root", "root", 10));
		}
		if (!userService.isLoginInUse("jane")) {
			userService.create(new Member("jane", "jane", "jane", "doe", null));
		}
		
	}

}
