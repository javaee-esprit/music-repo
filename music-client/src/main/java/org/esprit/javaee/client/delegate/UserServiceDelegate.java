package org.esprit.javaee.client.delegate;

import java.util.List;

import org.esprit.javaee.client.locator.ServiceLocator;
import org.esprit.javaee.persistence.Member;
import org.esprit.javaee.persistence.User;
import org.esprit.javaee.services.interfaces.UserServiceRemote;

public class UserServiceDelegate {
	
	private static String jndiName;

	private static UserServiceRemote getProxy(){
		jndiName = "music-ejb/UserService!"+UserServiceRemote.class.getCanonicalName();
		return (UserServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static User authenticate(String login, String password) {
		return getProxy().authenticate(login, password);
	}

	public static Boolean isLoginInUse(String login) {
		return getProxy().isLoginInUse(login);
	}

	public static void create(User user) {
		getProxy().create(user);
	}

	public static List<User> listAllUser() {
		return getProxy().listAllUser();
	}

	public static List<Member> listAllMembers() {
		return getProxy().listAllMembers();
	}

}
