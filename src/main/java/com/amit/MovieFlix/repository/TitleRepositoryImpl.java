package com.amit.MovieFlix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.amit.MovieFlix.entity.TitleComments;
import com.amit.MovieFlix.entity.TitleDetails;
import com.amit.MovieFlix.entity.TitleEntity;
import com.amit.MovieFlix.entity.UserTitleRating;

@Repository
public class TitleRepositoryImpl implements TitleRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<TitleEntity> findAll() {
		TypedQuery<TitleEntity> query = em.createQuery("from TitleEntity", TitleEntity.class); 
		return query.getResultList();
	}

	@Override
	public TitleEntity findOne(String id) {
		return em.find(TitleEntity.class, id);
	}
	
	
	@Override
	public TitleEntity create(TitleEntity title) {
		em.persist(title);
		TitleDetails details = createTitleDetailsObject(title);
		em.persist(details);
		em.flush();
		return title;
	}

	@Override
	public TitleEntity update(TitleEntity title) {
		TitleDetails details = createTitleDetailsObject(title);
		em.merge(details);
		return em.merge(title);
	}
	
	//Create an object of TitleDetails for a title
	public TitleDetails createTitleDetailsObject(TitleEntity title){
		TitleDetails details = new TitleDetails();
		details.setImdbID(title.getImdbID());
		details.setActors(title.getActors());
		details.setDirector(title.getDirector());
		details.setImdbRating(title.getImdbRating());
		details.setPlot(title.getPlot());
		return details;
	}

	@Override
	public void delete(TitleEntity title) {
		TypedQuery<TitleDetails> query = em.createQuery("from TitleDetails", TitleDetails.class); 
		TitleDetails titleDetails = query.getSingleResult();
		em.remove(titleDetails);
		em.remove(title);		
	}

	@Override
	public List<TitleEntity> search(String keyword) {
		TypedQuery<TitleEntity> query = em.createNamedQuery("TitleEntity.searchInTitles", TitleEntity.class);
		query.setParameter("searchText", "%"+keyword+"%");
		List<TitleEntity> titles = query.getResultList();
		if(titles != null)
			return titles;
		return null;
	}

	@Override
	public TitleDetails getTitleDetails(String id) {
		return em.find(TitleDetails.class, id);
	}

	@Override
	public TitleComments commentOnTitle(TitleComments comment) {	
		comment.setCommentedBy("User authentication yet to be implemented");
		em.persist(comment);
		return comment;
	}

	@Override
	public List<TitleComments> viewCommentOnTitle(String titleID) {
		TypedQuery<TitleComments> query = em.createNamedQuery("TitleComments.findByTitleID", TitleComments.class); 
		query.setParameter("pID", titleID);
		List<TitleComments> comments = query.getResultList();
		if(comments != null)
			return comments;
		return null;
	}

	@Override
	public UserTitleRating rateOnTitle(UserTitleRating rating) {
		rating.setRatedBy("User authentication yet to be implemented");
		em.persist(rating);	
		return rating;
	}

	@Override
	public Double viewRatingOnTitle(String titleID) {
		TypedQuery<Double> query = em.createNamedQuery("UserTitleRating.findAvgRatingByTitleID", Double.class); 
		query.setParameter("pID", titleID);
		Double rating = query.getSingleResult();
		if(rating != null)
			return rating;
		return null;
	}

	@Override
	public List<TitleEntity> getTopTitles(String type) {
		TypedQuery<TitleEntity> query = em.createNamedQuery("TitleEntity.topTitles", TitleEntity.class); 
		query.setParameter("pType", type);
		query.setMaxResults(50);
		return query.getResultList();
	}

	@Override
	public List<TitleEntity> filterTitlesByType(String type) {
		TypedQuery<TitleEntity> query = em.createNamedQuery("TitleEntity.filterTitlesByType", TitleEntity.class); 
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public List<TitleEntity> filterTitlesByYear(String year) {
		TypedQuery<TitleEntity> query = em.createNamedQuery("TitleEntity.filterTitlesByYear", TitleEntity.class); 
		query.setParameter("pYear", year);
		return query.getResultList();
	}

	@Override
	public List<TitleEntity> filterTitlesByGenre(String genre) {
		TypedQuery<TitleEntity> query = em.createNamedQuery("TitleEntity.filterTitlesByGenre", TitleEntity.class); 
		query.setParameter("pGenre", "%"+genre+"%");
		return query.getResultList();
	}

	@Override
	public List<TitleEntity> sortTitles(String sort) {
		System.out.println("String is: "+sort);
		if(sort == "votes"){
			TypedQuery<TitleEntity> query = em.createNamedQuery("TitleEntity.sortTitlesByVotes", TitleEntity.class); 
			return query.getResultList();
		}
		else if(sort == "year"){
			TypedQuery<TitleEntity> query = em.createNamedQuery("TitleEntity.sortTitlesByYear", TitleEntity.class); 
			return query.getResultList();
		}
		else if(sort == "rating"){
			TypedQuery<TitleEntity> query = em.createNamedQuery("TitleEntity.sortTitlesByRating", TitleEntity.class); 
			return query.getResultList();
		}
		return null;
	}
}
