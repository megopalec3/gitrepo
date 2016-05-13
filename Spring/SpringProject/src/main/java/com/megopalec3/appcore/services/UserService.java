package com.megopalec3.appcore.services;

import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.dao.factory.UserFactory;
import com.megopalec3.appcore.entity.User;
import com.megopalec3.appcore.exceptions.ImageUploadException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserFactory userFactory;

    @Value("#{servletContext.contextPath}")
    private String servletContextPath;

    //TODO Just an example. Remove later
    @CacheEvict(value = "spitterCache", allEntries = true)
    public User addUser(User user) {
        User convertedUser = userFactory.convertUser(user);
        return userDao.addUser(convertedUser);
    }

    @Cacheable("spitterCache")
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    //TODO: Refactor to save images in Amazon S3???
    public void saveUserAvatar(MultipartFile image, User user) throws ImageUploadException {
        validateImage(image);
        try {
            File file = new File(getAvatarPath(user));
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new ImageUploadException("Unable to save image", e);
        }
    }

    private void validateImage(MultipartFile image) throws ImageUploadException {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only JPG images accepted");
        }
    }

    public String getAvatarPath(User user) {
        //TODO: Does not work
        return servletContextPath + "/WEB-INF/resources/image/useravatar/" + user.getId() + ".jpg";
    }
}
