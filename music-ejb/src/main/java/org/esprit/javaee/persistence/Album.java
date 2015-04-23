package org.esprit.javaee.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="t_album")
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private List<Song> songs;

	public Album() {
	}   
	
	
	public Album(Integer id, String name) {
		this.id = id;
		this.name = name;
	}


	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="album", cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}


	public String toString() {
		return "Album [id=" + id + ", name=" + name + "]";
	}
	@PreRemove
	public void beforeDeleting(){
		for(Song song : songs)
			song.setAlbum(null);
	}
	
	
   
}
