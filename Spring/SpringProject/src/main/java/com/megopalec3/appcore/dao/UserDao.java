package com.megopalec3.appcore.dao;

import com.megopalec3.appcore.entity.User;

public interface UserDao {

    void addUser(User user);

    User getUserById(long id);
}
