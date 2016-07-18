package com.amit.MovieFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.MovieFlix.entity.TitleEntity;
import com.amit.MovieFlix.service.TitleService;

@RestController
@RequestMapping(value="/titles")
public class FilterTitleController {

	@Autowired
	private TitleService service;

	//Filter titles by Type
		@RequestMapping(method=RequestMethod.GET, 
				value="/filter/type={type}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<TitleEntity> filterTitlesByType(@PathVariable("type") String type){
			return service.filterTitlesByType(type);
		}
		
	//Filter titles by Year
		@RequestMapping(method=RequestMethod.GET, 
				value="/filter/year={year}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<TitleEntity> filterTitlesByYear(@PathVariable("year") String year){
			return service.filterTitlesByYear(year);
		}
		
	//Filter titles by Genre
		
		@RequestMapping(method=RequestMethod.GET, 
				value="/filter/genre={genre}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<TitleEntity> filterTitlesByGenre(@PathVariable("genre") String genre){
			return service.filterTitlesByGenre(genre);
		}

}
