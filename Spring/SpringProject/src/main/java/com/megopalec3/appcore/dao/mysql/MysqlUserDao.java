package com.megopalec3.appcore.dao.mysql;

import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.entity.User;
import com.megopalec3.appcore.entity.mysql.MysqlUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class MysqlUserDao implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public MysqlUser getUserById(long id) {
        return (MysqlUser) getCurrentSession().get(MysqlUser.class, id);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
