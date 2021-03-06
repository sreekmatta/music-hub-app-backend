package edu.neu.cs5200.orm.jpa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("CRITIC")
public class Critic extends Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Critic() {
		
	}
	
	public Critic(Person p) {
		this.setFirstName(p.getFirstName());
		this.setLastName(p.getLastName());
		this.setUsername(p.getUsername());
		this.setEmail(p.getEmail());
		this.setPassword(p.getPassword());
	}
		
	@OneToMany(mappedBy = "critic")
	private List<Rating> ratings;
	
	@OneToMany(mappedBy = "author")
	private List<Review> reviews;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="likers", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Track> likes;

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Track> getLikes() {
		return likes;
	}

	public void setLikes(List<Track> likes) {
		this.likes = likes;
	}
}
