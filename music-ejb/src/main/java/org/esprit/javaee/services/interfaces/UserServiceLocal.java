package org.esprit.javaee.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import org.esprit.javaee.persistence.Member;
import org.esprit.javaee.persistence.User;

@Local
public interface UserServiceLocal {
	
	Boolean isLoginInUse(String login);
	void create(User user);
	List<User> listAllUser();
	List<Member> listAllMembers();
	User authenticate(String login, String password);

}
