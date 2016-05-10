package com.megopalec3.appcore.services;


import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    //TODO Just an example. Remove later
    @CacheEvict(value = "spitterCache", allEntries=true)
    public User addUser(User user) {
        return userDao.addUser(user);
    }
    @Cacheable("spitterCache")
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
