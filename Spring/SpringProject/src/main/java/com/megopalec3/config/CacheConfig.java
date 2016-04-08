package com.megopalec3.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheConfig {
    private static final String CACHE_RESOURCE_FILE = "ehcache.xml";

    @Bean
    public CacheManager ehCacheManager(){
        return  new EhCacheCacheManager(ehCacheFactory().getObject());
    }
    @Bean
    public EhCacheManagerFactoryBean ehCacheFactory(){
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        factoryBean.setConfigLocation(new ClassPathResource(CACHE_RESOURCE_FILE));
        factoryBean.setShared(true);
        return factoryBean;
    }
}
