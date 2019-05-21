package com.example.controller;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.example.services.CommentService;
import com.example.models.CommentJSON;

@CrossOrigin(origins = "http://localhost:8082")
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
		return commentService.addComment(comment);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deletePost(@Valid @RequestBody CommentJSON comment) {
		commentService.deleteComment(comment);
		return "Commentaire supprimé";
	}
	
	
	
}
