package com.amit.MovieFlix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "TitleDetails.findByID", query = "Select u from TitleDetails u where u.imdbID=:pID"),
		}
)
public class TitleDetails {
	
	@Id
	@Column(unique=true)
	private String imdbID;
	
	@Column(name="Director")
	private String Director;
	
	@Column(name="Actors")
	private String Actors;
	
	@Column(name="Plot")
	private String Plot;
	
	private String imdbRating;
	
	
	@JsonProperty("Director")
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	
	@JsonProperty("Actors")
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	
	@JsonProperty("Plot")
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

}
