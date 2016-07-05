package com.bakigoal.config;

import com.bakigoal.service.DataSourceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by ilmir on 05.07.16.
 */
@Configuration
@ComponentScan(basePackages = "com.bakigoal")
@ImportResource("classpath:/properties-config.xml")
public class AppConfig {

  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.username}")
  private String username;
  @Value("${jdbc.password}")
  private String password;

  @Bean
  public DataSourceService dataSource() {
    return new DataSourceService(url + "/" + username + "/" + password);
  }
}
