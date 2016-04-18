package com.megopalec3.appcore.services;


import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
