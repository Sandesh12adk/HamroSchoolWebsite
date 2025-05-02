package com.project.hamroschool.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MyBeanFactory {
  /*  @Bean
    public DataSource mydatasource(){
        DriverManagerDataSource datasource= new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/hamroschool");
        datasource.setUsername("root");
        datasource.setPassword("san123@M");
        return datasource;
    }

   */
}
