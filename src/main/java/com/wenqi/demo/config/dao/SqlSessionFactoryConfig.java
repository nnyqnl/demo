package com.wenqi.demo.config.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SqlSessionFactoryConfig {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException{

        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        //数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //mapper配置文件的位置
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        //String path=PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+"/mapper/**.xml";
        String path="classpath*:/mapper/**.xml";
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(path));
        //实体类，别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.wenqi.demo.domain");
        //指定mybatis-config.xml
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sqlSessionFactoryBean;
    }
}
