package com.amit.MovieFlix.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "UserTitleRating.findAvgRatingByTitleID", query = "SELECT AVG(u.Rating) FROM UserTitleRating u WHERE u.imdbID =:pID"),
		}
)
public class UserTitleRating {
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@GeneratedValue(generator = "system-uuid")
	private String RatingID;
	private String ratedBy;
	private String Rating;
	private String imdbID;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RatedOn", updatable=true)
    private Date ratedOn;

    @PrePersist
    protected void onCreate() {
    	ratedOn = new Date();
    }

    @JsonProperty("Rated On")
    public Date getCreated() {
		return ratedOn;
	}

	public void setCreated(Date ratedOn) {
		this.ratedOn = ratedOn;
	}
	
	
	@JsonProperty("Rating")
	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	@JsonProperty("RatedBy")
	public String getRatedBy() {
		return ratedBy;
	}

	public void setRatedBy(String ratedBy) {
		this.ratedBy = ratedBy;
	}


	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	
}
