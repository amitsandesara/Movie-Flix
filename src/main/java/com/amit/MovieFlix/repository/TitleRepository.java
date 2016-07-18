package com.amit.MovieFlix.repository;

import java.util.List;

import com.amit.MovieFlix.entity.TitleComments;
import com.amit.MovieFlix.entity.TitleDetails;
import com.amit.MovieFlix.entity.TitleEntity;
import com.amit.MovieFlix.entity.UserTitleRating;

public interface TitleRepository {
	
	public List<TitleEntity> findAll();
	public TitleEntity findOne(String id);
	public TitleEntity create(TitleEntity title);
	public TitleEntity update(TitleEntity title);
	public void delete(TitleEntity title);
	public List<TitleEntity> search(String keyword);
	public TitleDetails getTitleDetails(String id);
	public TitleComments commentOnTitle(TitleComments id);
	public List<TitleComments> viewCommentOnTitle(String titleID);
	public UserTitleRating rateOnTitle(UserTitleRating rating);
	public Double viewRatingOnTitle(String titleID);
	public List<TitleEntity> getTopTitles(String type);
	public List<TitleEntity> filterTitlesByType(String type);
	public List<TitleEntity> filterTitlesByYear(String year);
	public List<TitleEntity> filterTitlesByGenre(String genre);
	public List<TitleEntity> sortTitles(String string);
}
