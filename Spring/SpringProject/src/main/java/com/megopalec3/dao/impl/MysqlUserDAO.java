package com.megopalec3.dao.impl;

import com.megopalec3.dao.UserDAO;
import com.megopalec3.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public User getUserById(long id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}