package org.esprit.javaee.services.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.esprit.javaee.persistence.Member;
import org.esprit.javaee.persistence.User;
import org.esprit.javaee.services.interfaces.UserServiceLocal;
import org.esprit.javaee.services.interfaces.UserServiceRemote;

@Stateless
public class UserService implements UserServiceRemote, UserServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    public UserService() {
    }

	public void create(User user) {
		em.persist(user);
		
	}

	public List<User> listAllUser() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	public List<Member> listAllMembers() {
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}

	public User authenticate(String login, String password) {
		User found = null;
		TypedQuery<User> query = em.createQuery("select u from User u where u.login=:x and u.password=:y", User.class);
		query.setParameter("x", login);
		query.setParameter("y", password);
		try{
			found = query.getSingleResult();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName()).log(Level.WARNING, "auth attempt failed with login='"+login+"' and password='"+password+"'");
		}
		return found;
	}

	@Override
	public Boolean isLoginInUse(String login) {
		
		return em.createNamedQuery("isLoginInUse", Boolean.class).setParameter("x", login).getSingleResult();
	}

}
