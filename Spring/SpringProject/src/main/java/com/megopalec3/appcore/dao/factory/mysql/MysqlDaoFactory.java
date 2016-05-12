package com.megopalec3.appcore.dao.factory.mysql;

import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.dao.factory.DaoFactory;
import com.megopalec3.appcore.dao.factory.UserFactory;
import com.megopalec3.appcore.dao.mysql.MysqlUserDao;

public class MysqlDaoFactory implements DaoFactory {

    @Override
    public UserDao getUserDao() {
        return new MysqlUserDao();
    }

    @Override
    public UserFactory getUserFactory() {
        return new MysqlUserFactory();
    }
}