
package com.example.helper;

import com.example.models.User;
import com.example.models.UserJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapTo(UserJSON userJSON) {
        Assert.notNull(userJSON, "The userJSON must not be null");
        User u = new User();
        // must not set id !
        u.setUsername(userJSON.getUsername());
        u.setPassword(userJSON.getPassword());
        return u;
    }

    public UserJSON mapTo(User user) {
        Assert.notNull(user, "The user must not be null");
        UserJSON uJSON = new UserJSON();
        uJSON.setUsername(user.getUsername());
        uJSON.setPassword(user.getPassword());
        uJSON.setId(user.getId());
        return uJSON;
    }

    public List<UserJSON> mapTo(List<User> userList) {
        Assert.notNull(userList, "The userList must not be null");
        return userList.stream().map(user -> this.mapTo(user)).collect(Collectors.toList());
    }
}