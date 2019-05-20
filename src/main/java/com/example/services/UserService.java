package com.example.services;

import com.example.helper.UserMapper;
import com.example.models.User;
import com.example.models.UserJSON;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper mapper;

    public List<UserJSON> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return mapper.mapTo(userList);
    }

    public UserJSON getUserById(long id) {
        User u = userRepository.getOne(id);
        return mapper.mapTo(u);
    }

    public UserJSON addUser(UserJSON user) {
        User u = userRepository.save(mapper.mapTo(user));
        return mapper.mapTo(u);
    }

    /*public List<UserJSON> getAllBooksByAuthor(String author) {
        List<User> bookList = bookRepository.findByAuthor(author);
        return mapper.mapTo(bookList);
    }*/
}