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
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Component
@PropertySource("classpath:properties/common.properties")
public class UserService {
    private static final String USER_AVATAR_PATH = "/useravatar/";

    @Autowired
    public UserService(ServletContext servletContext) {
        servletContextPath = servletContext.getContextPath();
    }

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserFactory userFactory;

    private String servletContextPath;

    @Value("${image.useravatar.filesystempath}")
    private String userAvatarRealPath;

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
            File file = new File(getAvatarRealPath(user));
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

    //TODO: save to 'avatarCache'
    @Cacheable("spitterCache")
    public String getAvatarContextPath(User user) {
        return servletContextPath + USER_AVATAR_PATH + user.getId() + ".jpg";
    }

    private String getAvatarRealPath(User user) {
        return userAvatarRealPath + user.getId() + ".jpg";
    }
}
