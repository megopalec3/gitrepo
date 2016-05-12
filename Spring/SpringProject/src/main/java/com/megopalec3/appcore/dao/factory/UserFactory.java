package com.megopalec3.appcore.dao.factory;

import com.megopalec3.appcore.entity.User;

public interface UserFactory {

    User getUserInstance();

    User convertUser(User user);
}