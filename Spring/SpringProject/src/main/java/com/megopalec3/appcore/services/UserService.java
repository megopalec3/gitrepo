package com.megopalec3.appcore.services;

import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.dao.factory.UserFactory;
import com.megopalec3.appcore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserFactory userFactory;

    //TODO Just an example. Remove later
    @CacheEvict(value = "spitterCache", allEntries=true)
    public User addUser(User user) {
        User convertedUser = userFactory.convertUser(user);
        return userDao.addUser(convertedUser);
    }

    @Cacheable("spitterCache")
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
