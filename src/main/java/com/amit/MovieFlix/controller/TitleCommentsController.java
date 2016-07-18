package com.amit.MovieFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.MovieFlix.entity.TitleComments;
import com.amit.MovieFlix.service.TitleService;

@RestController
@RequestMapping(value="/titles")
public class TitleCommentsController {
	@Autowired
	private TitleService service;
	
	
	//Comment on a title
		@RequestMapping(method=RequestMethod.POST, 
				value="/postComment",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE, 
				consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public TitleComments commentOnTitle(@RequestBody TitleComments comment){
			return service.commentOnTitle(comment);
		}

	//View Comments on a title
		@RequestMapping(method=RequestMethod.GET, 
				value="/{id}/viewComments",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<TitleComments> viewCommentOnTitle(@PathVariable("id") String titleID){
			return service.viewCommentOnTitle(titleID);
		}

}
