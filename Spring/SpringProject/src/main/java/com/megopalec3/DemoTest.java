package com.megopalec3;

import com.megopalec3.appcore.entity.User;
import com.megopalec3.appcore.entity.mysql.MysqlUser;
import com.megopalec3.appcore.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TODO: Remove class
public class DemoTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        UserService userService = (UserService) context.getBean("userService");
        //userService.addUser(new MysqlUser().setUserName("Name").setPassword("Pass"));
        User user = userService.getUserById(1);
        System.out.println(user.getId() + user.getUserName() + user.getPassword());
    }
}
