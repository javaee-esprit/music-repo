package org.esprit.javaee.client.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.persistence.Album;
import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.SongServiceRemote;

public class _04JPQLFindSongsByAlbum {
	
	public static void main(String[] args) throws NamingException {
		
		SongServiceRemote proxy =
				(SongServiceRemote) 
				new InitialContext()
				.lookup("/music-ejb/SongService!"+SongServiceRemote.class.getCanonicalName());
		
		
		Album a2 = new Album(2, "B");
		
		
		
		List<Song> songs =  proxy.findSongsByAlbum(a2);
		for (Song song : songs) {
			System.out.println(song);
		}
		
	}

}
