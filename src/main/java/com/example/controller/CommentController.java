package com.example.controller;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.example.services.CommentService;
import com.example.models.Comment;
import com.example.models.CommentJSON;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Resource
	private CommentService commentService;
		
	@RequestMapping(method = RequestMethod.GET)
	public List<CommentJSON> getAll(){
		return commentService.getAllComments();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/post/{post}")
	public List<CommentJSON> getAllByPost(@PathVariable int post){
		return commentService.getAllCommentsByPost(post);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public CommentJSON addComment(@Valid @RequestBody CommentJSON comment) {
		// test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
		// or JPA RollbackException (DB side)
		return commentService.addComment(comment);
	}
	
}
