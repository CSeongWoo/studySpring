package com.ssafy.study.common.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/testspring?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Seoul&characterEncoding=UTF-8");
//        dataSourceBuilder.username("ssafy");
//        dataSourceBuilder.password("ssafy");
//        dataSourceBuilder.build();
//        return dataSourceBuilder.build();
//    }
}
