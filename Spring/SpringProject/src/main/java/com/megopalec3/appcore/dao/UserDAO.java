package com.megopalec3.appcore.dao;

import com.megopalec3.appcore.entity.mysql.MysqlUser;

public interface UserDao {

    void addUser(MysqlUser user);

    MysqlUser getUserById(long id);
}
