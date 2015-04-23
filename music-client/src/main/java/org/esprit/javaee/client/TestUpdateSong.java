package org.esprit.javaee.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.SongServiceRemote;

public class TestUpdateSong {
	
	public static void main(String[] args) throws NamingException {
		SongServiceRemote proxy =
				(SongServiceRemote) 
				new InitialContext()
				.lookup("/music-ejb/SongService!"+SongServiceRemote.class.getCanonicalName());
		
		Song song = new Song(2, "goodbye");
		proxy.update(song);
		
	}

}
