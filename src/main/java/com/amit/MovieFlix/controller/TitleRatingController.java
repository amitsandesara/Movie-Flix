package com.amit.MovieFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.MovieFlix.entity.TitleEntity;
import com.amit.MovieFlix.entity.UserTitleRating;
import com.amit.MovieFlix.service.TitleService;

@RestController
@RequestMapping(value="/titles")
public class TitleRatingController {

	@Autowired
	private TitleService service;

	//Post rating on a title
		@RequestMapping(method=RequestMethod.POST, 
				value="/postRating",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE, 
				consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public UserTitleRating rateOnTitle(@RequestBody UserTitleRating rating){
			return service.rateOnTitle(rating);
		}
		
	//View average user rating of a title
		@RequestMapping(method=RequestMethod.GET, 
				value="/{id}/viewRating",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public String viewRatingOnTitle(@PathVariable("id") String titleID){
			return service.viewRatingOnTitle(titleID);
		}
		
	//View top rated movies and TV series
		@RequestMapping(method=RequestMethod.GET, 
				value="/top={type}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<TitleEntity> viewTopRatedTitle(@PathVariable("type") String type){
			return service.viewTopRatedTitle(type);
		}
		
}
