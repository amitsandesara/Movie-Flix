package com.amit.MovieFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.MovieFlix.entity.TitleEntity;
import com.amit.MovieFlix.service.TitleService;

@RestController
@ResponseBody
public class SortTitleController {
	
	@Autowired
	private TitleService service;
	
	//Sort by ImdbVotes/Year/ImdbRating
		@RequestMapping(method=RequestMethod.GET, 
				value="/sortbyvotes",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<TitleEntity> sortTitlesByImdbVotes(){
			System.out.println("Request to sort by votes");
			return service.sortTitles("votes");
		}
		
	//Sort title by year
		@RequestMapping(method=RequestMethod.GET, 
				value="/sortbyyear",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<TitleEntity> sortTitlesByYear(){
			System.out.println("Request to sort by year");
			return service.sortTitles("year");
		}
		
	//Sort title by ImdbRatings
		@RequestMapping(method=RequestMethod.GET, 
				value="/sortbyrating",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<TitleEntity> sortTitlesByImdbRating(){
			System.out.println("Request to sort by ImdbRating");
			return service.sortTitles("rating");
		}
}
