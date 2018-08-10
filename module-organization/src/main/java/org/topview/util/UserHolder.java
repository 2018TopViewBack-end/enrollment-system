package org.topview.util;

import org.springframework.stereotype.Component;
import org.topview.entity.User;

/**
 * Created by RojerAlone on 2017/6/11.
 * 每次请求时存放请求者的信息
 */
@Component
public class UserHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void remove() {
        users.remove();
    }
}
