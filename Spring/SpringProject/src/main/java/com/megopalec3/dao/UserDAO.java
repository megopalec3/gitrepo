package com.megopalec3.dao;

import com.megopalec3.entity.User;

public interface UserDAO {

    void addUser(User user);

    User getUserById(long id);
}
