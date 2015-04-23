package org.esprit.javaee.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_song")
public class Song implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String title;
	private Double size;
	private Date releaseDate;
	private Boolean single;
	private byte[] data;
	private String lyrics;
	private Integer age;
	private Album album;
	private List<Tag> tags;
	private List<Rating> ratings;
	
	public Song() {
	}
	
	

	@Id 
	public Integer getId() {
		return id;
	}


	
	public Song(Integer id, String title) {
		this.id = id;
		this.title = title;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(columnDefinition="Decimal(3,2) default 0.0")
	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	@Column( name = "realease_date" )
	@Temporal(TemporalType.DATE)
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Boolean getSingle() {
		return single;
	}

	public void setSingle(Boolean single) {
		this.single = single;
	}

	@Lob
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Lob
	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	@Transient
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	
	@ManyToOne @JoinColumn(name="album_fk")
	public Album getAlbum() {
		return album;
	}



	public void setAlbum(Album album) {
		this.album = album;
	}


	@ManyToMany
	@JoinTable(	name="t_taggingsongs",
				joinColumns = @JoinColumn(name="song_fk"),
				inverseJoinColumns= @JoinColumn(name="tag_fk"),
				uniqueConstraints=@UniqueConstraint(columnNames={"song_fk", "tag_fk"})
			)
	public List<Tag> getTags() {
		return tags;
	}



	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}


	@OneToMany(mappedBy="song", cascade=CascadeType.REMOVE)
	public List<Rating> getRatings() {
		return ratings;
	}



	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}



	public String toString() {
		return "Song [id=" + id + ", title=" + title + "]";
	}
	
	
	

}
