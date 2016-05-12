package com.megopalec3.appcore.dao.factory.mysql;

import com.megopalec3.appcore.dao.factory.UserFactory;
import com.megopalec3.appcore.entity.User;
import com.megopalec3.appcore.entity.mysql.MysqlUser;

public class MysqlUserFactory implements UserFactory {

    @Override
    public User getUserInstance() {
        return new MysqlUser();
    }

    @Override
    public User convertUser(User user) {
        if (user.getClass().equals(MysqlUser.class)) {
            return user;
        }
        return getUserInstance()
                .setId(user.getId())
                .setUserName(user.getUserName())
                .setPassword(user.getPassword());
    }
}
