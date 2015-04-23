package org.esprit.javaee.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.SongServiceRemote;

public class TestAnything {
	@Loggable
	private Object o;
	
	
	public static void main(String[] args) throws NamingException {
		SongServiceRemote proxy =
				(SongServiceRemote) 
				new InitialContext()
				.lookup("/music-ejb/SongService!"+SongServiceRemote.class.getCanonicalName());
		
		Song song = new Song();
		System.out.println(song);
		System.out.println(proxy.doSomething(song));
		
	}

}
