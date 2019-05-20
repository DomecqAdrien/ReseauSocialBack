package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.example.services.PostService;
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
	
	@RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public PostJSON addComment(@Valid @RequestBody PostJSON post) {
		return postService.addPost(post);
	}
	
	@RequestMapping(method = RequestMethod.PUT, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public PostJSON editComment(@Valid @RequestBody PostJSON post) {
		return postService.editPost(post);
	}
}
