package com.example.services;

import com.example.helper.PostMapper;
import com.example.models.Post;
import com.example.models.PostJSON;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostService {

    @Resource
    private PostRepository postRepository;

    @Resource
    private PostMapper mapper;

    public List<PostJSON> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        return mapper.mapTo(postList);
    }

    public PostJSON getPostById(long id) {
        Post p = postRepository.getOne(id);
        return mapper.mapTo(p);
    }

    public PostJSON addPost(PostJSON post) {
        Post p = postRepository.save(mapper.mapTo(post));
        return mapper.mapTo(p);
    }
    
    public PostJSON editPost(PostJSON post) {
    	Post p = postRepository.findById(post.getId()).get();
    	p.setContenu(post.getContenu());
    	p.setTitre(post.getTitre());
    	postRepository.save(p);
    	return mapper.mapTo(p);
    }

}