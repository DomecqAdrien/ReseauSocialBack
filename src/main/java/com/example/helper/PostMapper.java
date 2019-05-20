
package com.example.helper;

import com.example.models.Post;
import com.example.models.PostJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public Post mapTo(PostJSON postJSON) {
        Assert.notNull(postJSON, "The userJSON must not be null");
        Post p = new Post();
        // must not set id !
        p.setTitre(postJSON.getTitre());
        p.setDate(postJSON.getDate());
        p.setContenu(postJSON.getContenu());
        p.setId_user(postJSON.getId_user());

        return p;
    }

    public PostJSON mapTo(Post post) {
        Assert.notNull(post, "The user must not be null");
        PostJSON pJSON = new PostJSON();
        pJSON.setTitre(post.getTitre());
        pJSON.setDate(post.getDate());
        pJSON.setContenu(post.getContenu());
        pJSON.setId_user(post.getId_user());
        pJSON.setId(post.getId());
        return pJSON;
    }

    public List<PostJSON> mapTo(List<Post> postList) {
        Assert.notNull(postList, "The userList must not be null");
        return postList.stream().map(post -> this.mapTo(post)).collect(Collectors.toList());
    }
}