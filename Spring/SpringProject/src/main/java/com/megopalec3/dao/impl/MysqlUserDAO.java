package com.megopalec3.dao.impl;

import com.megopalec3.dao.UserDAO;

import com.megopalec3.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Repository
//@Transactional
public class MysqlUserDAO implements UserDAO {
    private static final String SQL_INSERT_USER = "INSERT INTO user (name, password) VALUES (:name, :password)";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT id, name, password FROM user WHERE id = :id";

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", user.getUserName());
//        params.put("password", user.getPassword());
//        getNamedParameterJdbcTemplate().update(SQL_INSERT_USER, params);
    }

    @Override
 //   @Transactional
    public User getUserById(long id) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", id);
//        return getNamedParameterJdbcTemplate().queryForObject(SQL_SELECT_USER_BY_ID,
//                params,
//                (rs, rowNum) -> {
//                    User user = new User();
//                    user.setId(rs.getLong("id"));
//                    user.setUserName(rs.getString("name"));
//                    user.setPassword(rs.getString("password"));
//                    return user;
//                });
        return (User) getCurrentSession().get(User.class, id);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
