
package com.example.helper;

import com.example.models.Comment;
import com.example.models.CommentJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapper {

    public Comment mapTo(CommentJSON commentJSON) {
        Assert.notNull(commentJSON, "The userJSON must not be null");
        Comment c = new Comment();
        // must not set id !
        c.setCommentaire(commentJSON.getCommentaire());
        c.setDate(commentJSON.getDate());
        c.setPost(commentJSON.getPost());
        c.setId_user(commentJSON.getId_user());

        return c;
    }

    public CommentJSON mapTo(Comment c) {
        Assert.notNull(c, "The user must not be null");
        CommentJSON cJSON = new CommentJSON();
        cJSON.setId(c.getId());
        cJSON.setCommentaire(c.getCommentaire());
        cJSON.setDate(c.getDate());
        cJSON.setPost(c.getPost());
        cJSON.setId_user(c.getId_user());
        return cJSON;
    }

    public List<CommentJSON> mapTo(List<Comment> commentList) {
        Assert.notNull(commentList, "The userList must not be null");
        return commentList.stream().map(comment -> this.mapTo(comment)).collect(Collectors.toList());
    }
}