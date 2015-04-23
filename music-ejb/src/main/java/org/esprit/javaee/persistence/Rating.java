package org.esprit.javaee.persistence;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

@Entity
@Table(name="t_rating")
public class Rating implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private RatingPK pk;
	private Integer rate;
	private Member member;
	private Song song;

	public Rating() {
	}   
	
	public Rating(Member member, Song song, Integer rate) {
		this.getPk().setMemberId(member.getId());
		this.getPk().setSongId(song.getId());
		this.member = member;
		this.song = song;
		this.rate = rate;
	}

	@EmbeddedId
	public RatingPK getPk() {
		if (pk == null) {
			pk = new RatingPK();
		}
		return pk;
	}

	public void setPk(RatingPK pk) {
		this.pk = pk;
	}

	public Integer getRate() {
		return this.rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@ManyToOne
	@JoinColumn(name="member_fk", insertable = false, updatable = false)
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne
	@JoinColumn(name="song_fk", insertable = false, updatable = false)
	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
   
}
