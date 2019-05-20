package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.annotation.Resource;

import com.example.services.PostService;
import com.example.models.CommentJSON;
import com.example.models.PostJSON;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Resource
	private PostService postService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PostJSON> getAll(){
		return postService.getAllPosts();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{post}")
	public PostJSON getOnePost(@PathVariable int post){
		return postService.getPostById(post);
	}
	
	
	
}
