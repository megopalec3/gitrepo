package com.megopalec3;

import com.megopalec3.dao.UserDAO;
import com.megopalec3.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDao");
        userDAO.addUser(new User().setUserName("name").setPassword("password"));
    }
}
