package com.megopalec3.appcore.dao.mysql;

import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.entity.mysql.MysqlUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class MysqlUserDao implements UserDao <MysqlUser>{

    @Autowired
    private SessionFactory sessionFactory;

    public MysqlUser addUser(MysqlUser user) {
        getCurrentSession().save(user);
        return user;
    }

    @Override
    public MysqlUser getUserById(long id) {
        return (MysqlUser) getCurrentSession().get(MysqlUser.class, id);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}