package com.megopalec3.appcore.entity.mysql;

import com.megopalec3.appcore.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class MysqlUser implements User {

    @Id
    private long id;

    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public MysqlUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public long getId() {
        return id;
    }

    public MysqlUser setId(long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public MysqlUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}