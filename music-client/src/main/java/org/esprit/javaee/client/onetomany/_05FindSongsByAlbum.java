package org.esprit.javaee.client.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.persistence.Album;
import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.SongServiceRemote;

public class _05FindSongsByAlbum {
	
	public static void main(String[] args) throws NamingException {
		
		SongServiceRemote proxy =
				(SongServiceRemote) 
				new InitialContext()
				.lookup("/music-ejb/SongService!"+SongServiceRemote.class.getCanonicalName());
		
		
		Album a2 = proxy.findAlbumById(2);
		
		
		
		List<Song> songs =  a2.getSongs();
		for (Song song : songs) {
			System.out.println(song);
		}
		
	}

}
