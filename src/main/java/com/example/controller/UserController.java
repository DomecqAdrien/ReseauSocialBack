package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password){
		UserJSON u = userService.login(username);
		if(u.getPassword().equals(password)) {
			return "Connexion réussie";
		}
		return "Connexion refusée";
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.POST)
	public UserJSON register(@RequestParam("username") String username, @RequestParam("password") String password){
		UserJSON user = new UserJSON();
		user.setUsername(username);
		user.setPassword(password);
		return userService.addUser(user);
	}
	
	
	
}
