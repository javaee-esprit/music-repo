package org.esprit.javaee.client.tests;

import javax.naming.Context;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.SongServiceRemote;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class SongServiceTest {
	
	private SongServiceRemote proxy;
	
	@Before
	public void background(){
		Context ctx =null;
		try {
			ctx = new InitialContext();
			proxy = (SongServiceRemote) ctx.lookup("/music-ejb/SongService!"+SongServiceRemote.class.getCanonicalName());
		} catch (NamingException e) {
			e.printStackTrace();
		}
		proxy.create(new Song(5,"whatever"));
	}
	
	@Test
	public void itShouldFindASongById(){
		Song s = proxy.findById(5);
		assertNotNull(s);
	}
	
	@After
	public void reset(){
		proxy.delete(new Song(5,"whatever"));
	}
	

}
