package org.esprit.javaee.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="t_tag")
public class Tag implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private List<Song> songs;

	public Tag() {
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

	@ManyToMany(mappedBy="tags")
	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
   
}
