package com.megopalec3.config;

import com.megopalec3.appcore.dao.UserDAO;
import com.megopalec3.appcore.dao.impl.MysqlUserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanConfigurator {

    @Bean
    public UserDAO userDao() {
        return new MysqlUserDAO();
    }
}
