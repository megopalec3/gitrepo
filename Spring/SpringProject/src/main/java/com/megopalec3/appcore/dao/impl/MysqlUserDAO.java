package com.megopalec3.appcore.dao.impl;

import com.megopalec3.appcore.dao.UserDAO;
import com.megopalec3.appcore.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springmodules.cache.annotations.CacheFlush;

import javax.transaction.Transactional;

@Repository
@Transactional
public class MysqlUserDAO implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    @Cacheable("spitterCache")
    public User getUserById(long id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @CacheFlush(modelId = "spitterCache")
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}