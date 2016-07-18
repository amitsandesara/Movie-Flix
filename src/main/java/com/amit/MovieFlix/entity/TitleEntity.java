package com.amit.MovieFlix.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "TitleEntity.findByID", query = "Select u from TitleEntity u where u.imdbID=:pID"),
			@NamedQuery(name = "TitleEntity.searchInTitles", query = "Select u from TitleEntity u where u.Title like :searchText"),	
			@NamedQuery(name = "TitleEntity.topTitles", query="Select u from TitleEntity u where u.Type =:pType order by u.imdbRating desc"),
			@NamedQuery(name = "TitleEntity.filterTitlesByType", query="Select u from TitleEntity u where u.Type =:pType order by u.imdbRating desc"),
			@NamedQuery(name = "TitleEntity.filterTitlesByYear", query="Select u from TitleEntity u where u.Year =:pYear order by u.imdbRating desc"),
			@NamedQuery(name = "TitleEntity.filterTitlesByGenre", query="Select u from TitleEntity u where u.Genre like :pGenre order by u.imdbRating desc"),
			@NamedQuery(name = "TitleEntity.sortTitlesByVotes", query="Select u from TitleEntity u order by u.imdbVotes desc"),
			@NamedQuery(name = "TitleEntity.sortTitlesByYear", query="Select u from TitleEntity u order by u.Year desc"),
			@NamedQuery(name = "TitleEntity.sortTitlesByRating", query="Select u from TitleEntity u order by u.imdbRating desc"),	
		}
)
public class TitleEntity {

	@Id
	@Column(unique=true)
	private String imdbID;
	private String Year;
	private String Rated;
	@Column(name="Released")
	private String Released;
	@Column(name="Genre")
	private String Genre;
	@Column(name="Director")
	private String Director;
//	@NotNull(message="Actors cannot be empty")
	@Column(name="Actors")
	private String Actors;
	@Column(name="Writer")
	private String Writer;
//	@NotNull(message="Title cannot be empty")
	@Column(name="Title")
	private String Title;
	
//	@NotNull(message="Plot cannot be empty")
	@Column(name="Plot")
	private String Plot;
//	@NotEmpty(message="Runtime cannot be empty")
	@Column(name="Runtime")
	private String Runtime;
	@Column(name="Language")
	private String Language;
	@Column(name="Country")
	private String Country;
	@Column(name="Awards")
	private String Awards;
	@Column(name="Poster")
	private String Poster;
	@Column(name="Metascore")
	private String Metascore;
//	@NotNull(message="IMDB Ratings cannot be empty")
	private String imdbRating;
	private String imdbVotes;
//	@NotNull(message="Type type cannot be empty")
	@Column(name="Type")
	private String Type;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedOn", updatable=false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LastUpdated")
    private Date updated;
    
    @PrePersist
    protected void onCreate() {
    updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    updated = new Date();
    }
    
    public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	@JsonProperty("Year")
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	
	@JsonProperty("Rated")
	public String getRated() {
		return Rated;
	}
	public void setRated(String rated) {
		this.Rated = rated;
	}
	
	@JsonProperty("Released")
	public String getReleased() {
		return Released;
	}
	public void setReleased(String released) {
		Released = released;
	}
	
	@JsonProperty("Genre")
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	
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
	
	@JsonProperty("Writer")
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	
	@JsonProperty("Title")
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	
	@JsonProperty("Plot")
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	
	@JsonProperty("Runtime")
	public String getRuntime() {
		return Runtime;
	}
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	
	@JsonProperty("Language")
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	
	@JsonProperty("Country")
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	@JsonProperty("Awards")
	public String getAwards() {
		return Awards;
	}
	public void setAwards(String awards) {
		Awards = awards;
	}
	
	@JsonProperty("Poster")
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	
	@JsonProperty("Metascore")
	public String getMetascore() {
		return Metascore;
	}
	public void setMetascore(String metascore) {
		Metascore = metascore;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	
	@JsonProperty("Type")
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
}
