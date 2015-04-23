package org.esprit.javaee.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import org.esprit.javaee.persistence.Album;
import org.esprit.javaee.persistence.Song;

@Local
public interface SongServiceLocal {
	
	void create(Song song);
	Song findById(Integer id);
	List<Song> findAll();
	void update(Song song);
	void deleteById(Integer id);
	void delete(Song song);
	Song doSomething(Song song);
	
	void create(Album album);
	Album findAlbumById(Integer id);
	List<Album>  findAllAlbums();
	void update(Album album);
	void delete(Album album);
	
	List<Song> findSongsByAlbum(Album album);
	void addSongToAlbum(Song song, Album album);
	void removeFromAlbum(Song song);

}
