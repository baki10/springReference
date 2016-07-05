package com.bakigoal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ilmir on 05.07.16.
 */
@Configuration
@ComponentScan(basePackages = {"com.bakigoal.service", "com.bakigoal.dao"})
public class AppConfig {

}
