package com.amit.MovieFlix.service;

import java.util.List;

import com.amit.MovieFlix.entity.TitleComments;
import com.amit.MovieFlix.entity.TitleDetails;
import com.amit.MovieFlix.entity.TitleEntity;
import com.amit.MovieFlix.entity.UserTitleRating;

public interface TitleService {
	
	public List<TitleEntity> findAll();
	public TitleEntity create(TitleEntity title);
	public TitleEntity findOne(String id);
	public TitleEntity update(String id, TitleEntity title);
	public void delete(String id);
	public List<TitleEntity> search(String keyword);
	public TitleDetails getTitleDetails(String id);
	public String viewOnImdb(String id);
	public TitleComments commentOnTitle(TitleComments comment);
	public List<TitleComments> viewCommentOnTitle(String titleID);
	public UserTitleRating rateOnTitle(UserTitleRating rating);
	public String viewRatingOnTitle(String titleID);
	public List<TitleEntity> viewTopRatedTitle(String type);
	public List<TitleEntity> filterTitlesByType(String type);
	public List<TitleEntity> filterTitlesByYear(String year);
	public List<TitleEntity> filterTitlesByGenre(String genre);
	public List<TitleEntity> sortTitles(String string);
	
}
