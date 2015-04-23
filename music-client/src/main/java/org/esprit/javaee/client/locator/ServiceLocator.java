package org.esprit.javaee.client.locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.services.interfaces.UserServiceRemote;

public class ServiceLocator {
	
	private static ServiceLocator instance;
	
	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}
	
	private ServiceLocator() {
		cache = new HashMap<>();
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			throw new ServiceLocatorException(e);
		}
	}
	
	private Context ctx; 
	
	private Map<String, Object> cache;

	public synchronized Object getProxy(String jndiName) {
		Object proxy = cache.get(jndiName);
		if (proxy == null) {
			try {
				proxy = ctx.lookup(jndiName);
			} catch (NamingException e) {
				throw new ServiceLocatorException(e);
			}
			cache.put(jndiName, proxy);
		}
		return proxy;
	}
	
	

}
