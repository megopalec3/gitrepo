package com.megopalec3.config;

import com.megopalec3.appcore.dao.UserDao;
import com.megopalec3.appcore.dao.factory.DaoFactory;
import com.megopalec3.appcore.dao.factory.mysql.MysqlDaoFactory;
import com.megopalec3.appcore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("properties/common.properties")
public class CustomBeanConfigurator {
    private static final String PROPERTY_NAME_DATA_STORAGE_TYPE = "datastorage.type";
    private static final String DAO_TYPE_MYSQL = "mysql";

    @Autowired
    private Environment env;

    @Bean
    public DaoFactory daoFactory() {
        String storageType = env.getRequiredProperty(PROPERTY_NAME_DATA_STORAGE_TYPE);
        return  getDaoFactoryByType(storageType);
    }

    @Bean
    public UserDao userDao() {
        return daoFactory().getUserDao();
    }

    @Bean
    public UserService userService(){
        return new UserService();
    }

    //TODO: refactor finding DAOFactory by type
    private DaoFactory getDaoFactoryByType(String daoType) {
        switch(daoType.toLowerCase()){
            case DAO_TYPE_MYSQL: {
                return new MysqlDaoFactory();
            } default: {
                throw new IllegalArgumentException(String.format("Can not find DAO Factory by type '%s'", daoType));
            }
        }
    }
}
