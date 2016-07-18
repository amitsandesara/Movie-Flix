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
import com.amit.MovieFlix.service.TitleService;

@RestController
@RequestMapping(value="/titles")
public class TitleController {
	
	@Autowired
	private TitleService service;

//Find all titles
	@RequestMapping(method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TitleEntity> findAll(){
		return service.findAll();
	}
	
//Find a title
	@RequestMapping(method=RequestMethod.GET, 
			value="/{id}", 
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TitleEntity findOne(@PathVariable("id") String titleID){
		return service.findOne(titleID);
	}
	
//Create a new title
	@RequestMapping(method=RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE, 
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TitleEntity create(@RequestBody TitleEntity title){
		return service.create(title);
	}
	
//Update a title
	@RequestMapping(method=RequestMethod.PUT, 
			value="/{id}",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE, 
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TitleEntity update(@PathVariable("id") String titleID, @RequestBody TitleEntity title){
		return service.update(titleID, title);
	}
	
//Delete a title
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void delete(@PathVariable("id") String userId){
		service.delete(userId);
	}

}
