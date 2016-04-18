package com.megopalec3.appcore.entity;

public interface User {

    User setPassword(String password);
    String getPassword();

    User setId(long id);
    long getId();

    String getUserName();
    User setUserName(String userName);

}