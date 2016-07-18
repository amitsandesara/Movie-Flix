package com.amit.MovieFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.MovieFlix.entity.TitleDetails;
import com.amit.MovieFlix.entity.TitleEntity;
import com.amit.MovieFlix.service.TitleService;

@RestController
@RequestMapping(value="/titles")
public class GetTitleController {

	@Autowired
	private TitleService service;

	
	//View a title on IMDB Site
		@RequestMapping(method=RequestMethod.GET, 
				value="/{id}/viewOnImdb")
		public String viewOnImdb(@PathVariable("id") String id){
			return service.viewOnImdb(id);
		}
		
		//Get details about a title
		@RequestMapping(method=RequestMethod.GET, 
				value="/{id}/getDetails",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public TitleDetails getTitleDetails(@PathVariable("id") String id){
			return service.getTitleDetails(id);
		}
		
		
		//Search for a title	
			@RequestMapping(method=RequestMethod.GET, 
					value="/search={search}",
					produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
			public List<TitleEntity> search(@PathVariable("search") String keyword){
				return service.search(keyword);
			}


}