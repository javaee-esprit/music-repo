package org.esprit.javaee.client.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.persistence.Album;
import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.SongServiceRemote;

public class _03CascadingPersistOperation {
	
	public static void main(String[] args) throws NamingException {
		
		SongServiceRemote proxy =
				(SongServiceRemote) 
				new InitialContext()
				.lookup("/music-ejb/SongService!"+SongServiceRemote.class.getCanonicalName());
		
		Song s4 = new Song(4, "v");
		Song s5 = new Song(5, "w");
		
		Album a2 = new Album(2, "B");
		
		List<Song> songs = new ArrayList<>();
		songs.add(s4);
		songs.add(s5);
		
		s4.setAlbum(a2);
		s5.setAlbum(a2);
		
		a2.setSongs(songs);
		
		proxy.create(a2);
	}

}
