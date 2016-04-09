package com.megopalec3;

import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TODO: Remove class
public class DemoTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        System.out.println(context.getBean("sessionFactory"));
        UserDao userDao = (UserDao) context.getBean("userDao");
        //userDAO.addUser(new MysqlUser().setUserName("zxc").setPassword("zxc"));
        User user = userDao.getUserById(1);
        System.out.println(user.getId() + user.getUserName() + user.getPassword());
    }
}
