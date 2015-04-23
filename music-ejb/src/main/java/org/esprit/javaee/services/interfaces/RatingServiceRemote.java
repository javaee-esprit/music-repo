package org.esprit.javaee.services.interfaces;

import javax.ejb.Remote;

import org.esprit.javaee.persistence.Member;
import org.esprit.javaee.persistence.Song;

@Remote
public interface RatingServiceRemote {
	
	void rate(Member member, Song song,Integer rate);
	void cancelRate(Member member, Song song);
	Float averageRating(Song song);
	
}
