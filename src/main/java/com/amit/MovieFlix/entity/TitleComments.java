package com.amit.MovieFlix.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "TitleComments.findByTitleID", query = "Select u from TitleComments u where u.imdbID=:pID order by u.commentedOn desc"),
		}
)
public class TitleComments {
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@GeneratedValue(generator = "system-uuid")
	private String CommentID;
	private String commentedBy;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String Comments;
	private String imdbID;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CommentedOn", updatable=false)
    private Date commentedOn;

    @PrePersist
    protected void onCreate() {
    	commentedOn = new Date();
    }

    @JsonProperty("Commented On")
    public Date getCreated() {
		return commentedOn;
	}

	public void setCreated(Date commentedOn) {
		this.commentedOn = commentedOn;
	}
	
	
	@JsonProperty("Comments")
	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	@JsonProperty("CommentedBy")
	public String getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}


	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getCommentID() {
		return CommentID;
	}

	public void setCommentID(String commentID) {
		CommentID = commentID;
	}
	
}
