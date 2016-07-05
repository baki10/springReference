package com.bakigoal.config;

import com.bakigoal.service.DataSourceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

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
  @Profile("default")
  public DataSourceService dataSource() {
    return new DataSourceService(url + "/" + username + "/" + password);
  }

  @Bean
  @Profile("dev")
  public DataSourceService devDataSource() {
    return new DataSourceService("Development dataSource");
  }

  @Bean
  @Profile("production")
  public DataSourceService prodDataSource() {
    return new DataSourceService("JNDI Production dataSource");
  }
}
