package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.annotation.Resource;

import com.example.services.UserService;
import com.example.models.UserJSON;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Resource
	private UserService userService;
		
	@RequestMapping(method = RequestMethod.GET)
	public List<UserJSON> getAll(){
		return userService.getAllUsers();
	}
	
}
