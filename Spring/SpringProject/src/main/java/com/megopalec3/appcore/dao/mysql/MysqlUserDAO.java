package com.megopalec3.appcore.dao.mysql;

import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.entity.mysql.MysqlUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class MysqlUserDao implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    //TODO Just an example. Remove later
    @CacheEvict(value = "spitterCache", allEntries=true)
    public void addUser(MysqlUser user) {
        getCurrentSession().save(user);
    }

    @Override
    @Cacheable("spitterCache")
    public MysqlUser getUserById(long id) {
        return (MysqlUser) getCurrentSession().get(MysqlUser.class, id);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}