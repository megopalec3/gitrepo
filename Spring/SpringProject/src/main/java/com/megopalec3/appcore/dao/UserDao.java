package com.megopalec3.appcore.dao;

import com.megopalec3.appcore.entity.User;

public interface UserDao <E extends User>{

    E addUser(E user);

    E getUserById(long id);
}
