package com.wenqi.demo.config.dao;

import com.alibaba.druid.pool.DruidDataSource;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


@Configuration
@MapperScan("com.wenqi.demo.dao")
//mapper包扫描
public class DataSourceConfiguration
{
    @Value("${driverClass}")
    private String driverClass;
    @Value("${jdbcUser}")
    private String jdbcUser;
    @Value("${jdbcPassword}")
    private String jdbcPassword;
    @Value("${jdbcUrl}")
    private String jdbcUrl;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
//        ComboPooledDataSource dataSource=new ComboPooledDataSource();
            DruidDataSource dataSource=new DruidDataSource();
            dataSource.setDriverClassName(driverClass);
            dataSource.setUrl(jdbcUrl);
            dataSource.setUsername(jdbcUser);
            dataSource.setPassword(jdbcPassword);
//        dataSource.setDriverClass(driverClass);
//        dataSource.setUser(jdbcUser);
//        dataSource.setPassword(jdbcPassword);
//        dataSource.setJdbcUrl(jdbcUrl);
//        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
