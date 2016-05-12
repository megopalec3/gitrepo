package com.megopalec3.appcore.entity;

public class UserClientView implements User{

    private long id;
    private String userName;
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
