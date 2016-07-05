package com.bakigoal.config;

import com.bakigoal.dao.MovieDao;
import com.bakigoal.dao.impl.MovieDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ilmir on 05.07.16.
 */
@Configuration
@ComponentScan(basePackages = "com.bakigoal.service")
public class AppConfig {

  @Bean
  MovieDao movieDao(){
    return new MovieDaoImpl();
  }
}
