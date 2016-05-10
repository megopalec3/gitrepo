package com.megopalec3.appcore.entity.mysql;

import com.megopalec3.appcore.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class MysqlUser implements User {

    @Id
    @GeneratedValue(generator= "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
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