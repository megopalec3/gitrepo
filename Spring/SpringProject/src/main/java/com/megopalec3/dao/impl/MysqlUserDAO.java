package com.megopalec3.dao.impl;

import com.megopalec3.dao.UserDAO;

import com.megopalec3.entity.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.util.HashMap;
import java.util.Map;

public class MysqlUserDAO extends NamedParameterJdbcDaoSupport implements UserDAO {
    private static final String SQL_INSERT_USER = "INSERT INTO user (name, password) VALUES (:name, :password)";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT id, name, password FROM user WHERE id = :id";

    public void addUser(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getUserName());
        params.put("password", user.getPassword());
        getNamedParameterJdbcTemplate().update(SQL_INSERT_USER, params);
    }

    @Override
    public User getUserById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return getNamedParameterJdbcTemplate().queryForObject(SQL_SELECT_USER_BY_ID,
                params,
                (rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setUserName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    return user;
                });
    }

}
