package org.esprit.javaee.client.onetomany;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.persistence.Album;
import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.SongServiceRemote;

public class _02AddSomeSongsToAnAlbum {
	
	public static void main(String[] args) throws NamingException {
		
		SongServiceRemote proxy =
				(SongServiceRemote) 
				new InitialContext()
				.lookup("/music-ejb/SongService!"+SongServiceRemote.class.getCanonicalName());
		
		Song s1 = new Song(1, "x");
		Song s3 = new Song(3, "z");
		
		Album a1 = new Album(1, "A");
		
		proxy.addSongToAlbum(s1, a1);
		proxy.addSongToAlbum(s3, a1);
	}

}
