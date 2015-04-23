package org.esprit.javaee.client;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.SongServiceRemote;

public class TestFindAllSongs {
	
	public static void main(String[] args) throws NamingException {
		SongServiceRemote proxy =
				(SongServiceRemote) 
				new InitialContext()
				.lookup("/music-ejb/SongService!"+SongServiceRemote.class.getCanonicalName());
		
		List<Song> songs = proxy.findAll();
		
		for (Song song : songs) {
			System.out.println(song);
		}
		
	}

}
