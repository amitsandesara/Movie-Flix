package com.amit.MovieFlix.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amit.MovieFlix.entity.TitleComments;
import com.amit.MovieFlix.entity.TitleDetails;
import com.amit.MovieFlix.entity.TitleEntity;
import com.amit.MovieFlix.entity.UserTitleRating;
import com.amit.MovieFlix.exception.AlreadyExistsException;
import com.amit.MovieFlix.exception.MissingRatingDetails;
import com.amit.MovieFlix.exception.TitleNotFoundException;
import com.amit.MovieFlix.exception.UserNotFoundException;
import com.amit.MovieFlix.repository.TitleRepository;

@Service
@Transactional(readOnly=false)
public class TitleServiceImpl implements TitleService{

	@Autowired
	private TitleRepository repository;


	@Override
	public List<TitleEntity> findAll() {
		return repository.findAll();
	}
	
	@Override
	public TitleEntity create(TitleEntity title) {
		TitleEntity existing = repository.findOne(title.getImdbID());		
		if(existing != null)
			throw new AlreadyExistsException("Title with ID: "+title.getImdbID()+" already exists");
		return repository.create(title);
	}

	@Override
	public TitleEntity findOne(String id) {
		TitleEntity existing = repository.findOne(id);
		if(existing == null)
			return null;
		return existing;
	}

	@Override
	public TitleEntity update(String id, TitleEntity title) {
		TitleEntity existing = repository.findOne(id);
		if(existing == null)
			throw new UserNotFoundException("Title doesn't exist");
		return repository.update(title);	
	}

	@Override
	public void delete(String id) {
		TitleEntity existing = repository.findOne(id);
		if(existing == null)
			throw new UserNotFoundException("No title with ID- "+id+" found in the detabase");
		repository.delete(existing);
	}

	@Override
	public List<TitleEntity> search(String keyword) {
		List<TitleEntity> existing = repository.search(keyword);
		if(existing == null)
			throw new TitleNotFoundException("No title with keyword- "+keyword+"found");
		return existing;
	}

	@Override
	public TitleDetails getTitleDetails(String id) {
		TitleDetails existing = repository.getTitleDetails(id);
		if(existing == null)
			throw new TitleNotFoundException("No title with ID- "+id+"found");
		return existing;
	}

	@Override
	public String viewOnImdb(String id) {
		TitleEntity existing = repository.findOne(id);
		if(existing == null)
			throw new TitleNotFoundException("No title with ID- "+id+"found");
		return "Title: "+existing.getTitle()+"\nhttp://www.imdb.com/title/"+id+"/";
	}

	@Override
	public TitleComments commentOnTitle(TitleComments comment) {
		TitleEntity existing = repository.findOne(comment.getImdbID());
		if(existing == null)
			throw new TitleNotFoundException("No title with ID- "+comment.getImdbID()+"found");
		return repository.commentOnTitle(comment);
	}

	@Override
	public List<TitleComments> viewCommentOnTitle(String titleID) {
		TitleEntity existing = repository.findOne(titleID);
		if(existing == null){
			String error = "No title with ID: "+titleID+" found";
			throw new TitleNotFoundException(error);
		}
		return repository.viewCommentOnTitle(titleID);
	}

	@Override
	public UserTitleRating rateOnTitle(UserTitleRating rating) {
		TitleEntity existing = repository.findOne(rating.getImdbID());
		if(existing == null){
			String error = "No title with ID: "+rating.getImdbID()+" found";
			throw new TitleNotFoundException(error);
		}
		if(rating.getRating() == null)
			throw new MissingRatingDetails("Rating cannot be null and must be between 1 and 5");
		
		Double rate = Double.parseDouble(rating.getRating());
		System.out.println("User rating is: "+rate);
		if(rate < 1.0 || rate > 5.0)
			throw new MissingRatingDetails("Rating cannot be null and must be between 1 and 5");
		return repository.rateOnTitle(rating);
	}

	@Override
	public String viewRatingOnTitle(String titleID) {
		TitleEntity existing = repository.findOne(titleID);
		if(existing == null){
			String error = "No title with ID: "+titleID+" found";
			throw new TitleNotFoundException(error);
		}
		Double rating = repository.viewRatingOnTitle(titleID);
		
		DecimalFormat two = new DecimalFormat("#0.00");
		String finalRating = "Average User Rating of "+existing.getTitle()+": "+two.format(rating)+"/5" ; 
		return finalRating;
	}

	@Override
	public List<TitleEntity> viewTopRatedTitle(String type) {
		return repository.getTopTitles(type);
	}

	@Override
	public List<TitleEntity> filterTitlesByType(String type) {
		return repository.filterTitlesByType(type);
	}

	@Override
	public List<TitleEntity> filterTitlesByYear(String year) {
		return repository.filterTitlesByYear(year);
	}

	@Override
	public List<TitleEntity> filterTitlesByGenre(String genre) {
		return repository.filterTitlesByGenre(genre);
	}

	@Override
	public List<TitleEntity> sortTitles(String string) {
		System.out.println("String in Service class is: "+string);
		
		return repository.sortTitles(string);
	}

	

	
}
