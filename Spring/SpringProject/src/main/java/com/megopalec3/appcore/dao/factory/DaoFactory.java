package com.megopalec3.appcore.dao.factory;

import com.megopalec3.appcore.dao.UserDao;

public interface DaoFactory {

    UserDao getUserDao();

    UserFactory getUserFactory();
}
