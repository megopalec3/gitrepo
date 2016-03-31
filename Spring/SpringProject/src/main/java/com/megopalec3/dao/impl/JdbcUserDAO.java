package com.megopalec3.dao.impl;

import com.megopalec3.dao.UserDAO;

import com.megopalec3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcUserDAO implements UserDAO {
    private static final String SQL_INSERT_SPITTER = "INSERT INTO user (name, password) VALUES(?, ?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        jdbcTemplate.update(SQL_INSERT_SPITTER,
        user.getUserName(),
        user.getPassword());
    }

}
