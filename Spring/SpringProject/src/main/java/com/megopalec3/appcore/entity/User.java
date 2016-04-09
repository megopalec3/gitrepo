package com.megopalec3.appcore.entity;

public interface User {

    public String getPassword();

    public User setPassword(String password);

    public long getId();

    public User setId(long id);

    public String getUserName();

    public User setUserName(String userName);
}