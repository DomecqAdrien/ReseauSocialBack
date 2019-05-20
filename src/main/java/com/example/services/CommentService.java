package com.example.services;

import com.example.helper.CommentMapper;
import com.example.models.Comment;
import com.example.models.CommentJSON;
import com.example.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service
public class CommentService {

    @Resource
    private CommentRepository commentRepository;

    @Resource
    private CommentMapper mapper;

    public List<CommentJSON> getAllComments() {
        List<Comment> commentList = commentRepository.findAll();
        return mapper.mapTo(commentList);
    }

    public CommentJSON getCommentById(long id) {
    	Comment c = commentRepository.getOne(id);
        return mapper.mapTo(c);
    }

    public CommentJSON addComment(CommentJSON comment) {
    	Comment c = commentRepository.save(mapper.mapTo(comment));
        return mapper.mapTo(c);
    }
    
    public List<CommentJSON> getAllCommentsByPost(int post){
    	List<Comment> commentList = commentRepository.findByPostId(post);
		return mapper.mapTo(commentList);
    }

    /*public List<UserJSON> getAllBooksByAuthor(String author) {
        List<User> bookList = bookRepository.findByAuthor(author);
        return mapper.mapTo(bookList);
    }*/
}