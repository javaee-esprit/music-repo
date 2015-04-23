package org.esprit.javaee.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.client.delegate.UserServiceDelegate;
import org.esprit.javaee.persistence.Admin;
import org.esprit.javaee.persistence.Member;
import org.esprit.javaee.persistence.User;

public class TestAuthentication {

	public static void main(String[] args) throws NamingException {
		
		User found = UserServiceDelegate.authenticate("jane", "jane");

		if (found != null) {
			System.out.print("ACCESS GRANTED ");
			if (found instanceof Admin) {
				System.out.println("AS ADMIN");
			} else if (found instanceof Member) {
				System.out.println("AS MEMBER");
			} else if (found instanceof User) {
				System.out.println("AS GHOST");
			}

		} else {
			System.out.println("ACCESS DENIED");
		}
		 found = UserServiceDelegate.authenticate("root", "root");

		if (found != null) {
			System.out.print("ACCESS GRANTED ");
			if (found instanceof Admin) {
				System.out.println("AS ADMIN");
			} else if (found instanceof Member) {
				System.out.println("AS MEMBER");
			} else if (found instanceof User) {
				System.out.println("AS GHOST");
			}

		} else {
			System.out.println("ACCESS DENIED");
		}

	}

}
