package com.megopalec3.appcore.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserClientView implements User{

    private long id;

    @Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
    private String userName;

    @Size(min=6, max=20, message="The password must be between 6 and 20 characters long.")
    private String password;

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public UserClientView setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public UserClientView setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public UserClientView setPassword(String password) {
        this.password = password;
        return this;
    }
}
