package com.bakigoal;

import com.bakigoal.model.User;
import com.bakigoal.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ilmir on 05.07.16.
 */
public class Main {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"services.xml"});

    UserService userService = context.getBean("userService", UserService.class);
    printUsers(userService, "!!! UserService: !!!");

    UserService usersAlias = context.getBean("usersAlias", UserService.class);
    printUsers(usersAlias, "!!! ALIAS of UserService:!!!");

    UserService userFactoryMethod = context.getBean("userFactoryMethod", UserService.class);
    printUsers(userFactoryMethod, "!!! FACTORY METHOD BEAN !!!");

    context.registerShutdownHook();
  }

  private static void printUsers(UserService userService, String caption) {
    System.out.println(caption);
    for(User user: userService.getUsers()){
      System.out.println(user);
    }
  }
}
