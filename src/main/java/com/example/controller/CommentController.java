package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.annotation.Resource;

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
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void addComment(){
		
	}
	
}
