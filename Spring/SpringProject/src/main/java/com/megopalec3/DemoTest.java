package com.megopalec3;

import com.megopalec3.appcore.dao.UserDAO;
import com.megopalec3.appcore.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TODO: Remove class
public class DemoTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDao");
        for (int i = 0; i < 5; i++) {
            User user = userDAO.getUserById(1);
            System.out.println("ID:" + user.getId());
            System.out.println("NAME:" + user.getUserName());
            System.out.println("PASS:" + user.getPassword());
        }
        userDAO.addUser(new User().setUserName("zxc").setPassword("zxc"));
        User user = userDAO.getUserById(1);
    }
}
