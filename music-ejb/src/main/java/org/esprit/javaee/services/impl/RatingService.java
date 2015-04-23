package org.esprit.javaee.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.esprit.javaee.persistence.Member;
import org.esprit.javaee.persistence.Rating;
import org.esprit.javaee.persistence.Song;
import org.esprit.javaee.services.interfaces.RatingServiceLocal;
import org.esprit.javaee.services.interfaces.RatingServiceRemote;

@Stateless
public class RatingService implements RatingServiceRemote, RatingServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    public RatingService() {
    }

	public void rate(Member member, Song song, Integer rate) {
		Rating rating = new Rating(member, song, rate); 
		em.persist(rating);
	}

	public void cancelRate(Member member, Song song) {
		Rating rating = new Rating(member, song, null);
		em.remove(em.merge(rating));
	}

	public Float averageRating(Song song) {
		return null;
	}

}
