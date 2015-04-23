package org.esprit.javaee.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.esprit.javaee.persistence.Album;
import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.SongServiceLocal;
import org.esprit.javaee.services.interfaces.SongServiceRemote;

@Stateless
public class SongService implements SongServiceRemote, SongServiceLocal {

	@PersistenceContext
	private EntityManager em;

	public SongService() {
	}

	public void create(Song song) {
		em.persist(song);
	}

	public Song findById(Integer id) {
		return em.find(Song.class, id);
	}

	public List<Song> findAll() {
		return em.createQuery("select s from Song s", Song.class)
				.getResultList();
	}

	public void update(Song song) {
		em.merge(song);
	}

	public void deleteById(Integer id) {
		em.remove(em.find(Song.class, id));
	}

	public void delete(Song song) {
		em.remove(em.merge(song));
	}

	public Song doSomething(Song song) {
		
		Song managedOne = em.merge(song);
		return managedOne;
	}

	public void create(Album album) {
		em.persist(album);
		
	}

	public Album findAlbumById(Integer id) {
		return em.find(Album.class, id);
	}

	public List<Album> findAllAlbums() {
		List<Album> allAlbums = null;
		String jpql = "select a from Album a";
		TypedQuery<Album> query = em.createQuery(jpql, Album.class);
		allAlbums = query.getResultList();
		return allAlbums;
	}

	public void update(Album album) {
		em.merge(album);
	}

	public void delete(Album album) {
		em.remove(em.merge(album));
	}

	public List<Song> findSongsByAlbum(Album album) {
//		List<Song> albumSongs = null;
//		String jpql = "select s from Song s where s.album=:x";
//		TypedQuery<Song> query = em.createQuery(jpql, Song.class);
//		query.setParameter("x", album);
//		albumSongs = query.getResultList();
//		return albumSongs;
		return em
				.createQuery("select s from Song s where s.album=:x", Song.class)
				.setParameter("x", album)
				.getResultList();
	}

	public void addSongToAlbum(Song song, Album album) {
		song.setAlbum(album);
		em.merge(song);
	}

	public void removeFromAlbum(Song song) {
		song.setAlbum(null);
		em.merge(song);
	}

}
