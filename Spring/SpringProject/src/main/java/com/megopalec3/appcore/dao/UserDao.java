package com.megopalec3.appcore.dao;

import com.megopalec3.appcore.entity.User;

public interface UserDao {

    User addUser(User user);

    User getUserById(long id);
}
