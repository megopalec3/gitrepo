package com.megopalec3.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.util.Properties;

@Configuration
@PropertySource("properties/database.properties")
public class DataBaseConfig {
    private static final String PROPERTY_NAME_DRIVER_CLASSPATH = "database.driver.classpath";
    private static final String PROPERTY_NAME_DATABASE_URL = "database.url";
    private static final String PROPERTY_NAME_USER = "database.user.name";
    private static final String PROPERTY_NAME_PASSWORD = "database.user.password";
    private static final String PROPERTY_NAME_INITSIZE = "database.connection.pool.initsize";
    private static final String PROPERTY_NAME_MAXACTIVE = "database.connection.pool.maxactive";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";

    @Autowired
    private Environment env;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty(PROPERTY_NAME_DRIVER_CLASSPATH));
        dataSource.setUrl(env.getProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getProperty(PROPERTY_NAME_USER));
        dataSource.setPassword(env.getProperty(PROPERTY_NAME_PASSWORD));
        dataSource.setInitialSize(Integer.parseInt(env.getProperty(PROPERTY_NAME_INITSIZE)));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty(PROPERTY_NAME_MAXACTIVE)));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.megopalec3.appcore.entity");
        Properties hibernateProperties = getHibernateProperties();
        factoryBean.setHibernateProperties(hibernateProperties);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, HIBERNATE_DIALECT);
        return hibernateProperties;
    }
}
