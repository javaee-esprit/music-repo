package org.esprit.javaee.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.services.interfaces.SongServiceRemote;

public class TestDeleteSongById {
	
	public static void main(String[] args) throws NamingException {
		SongServiceRemote proxy =
				(SongServiceRemote) 
				new InitialContext()
				.lookup("/music-ejb/SongService!"+SongServiceRemote.class.getCanonicalName());
		
		
	}

}
