package com.bakigoal;

import com.bakigoal.dao.entity.Phone;
import com.bakigoal.dao.entity.User;
import com.bakigoal.service.UserPhoneService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public class HibernateMain {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});

    UserPhoneService service = context.getBean(UserPhoneService.class);

    //adding users
    List<User> users = generateUsers();
    for (User user : users) {
      service.addUser(user);
      System.out.println("Adding user: " + user);
    }

    List<User> userList = service.getUsers();
    System.out.println("===all===");
    printUsers(userList, service);

    System.out.println("removing users");
    service.getUsers().forEach(service::removeUser);
    System.out.println("----------------------------------------------");
    printUsers(service.getUsers(), service);

    context.registerShutdownHook();
  }

  private static void printUsers(List<User> users, UserPhoneService service) {
    System.out.println("------------- All Users --------------");
    users.forEach(user -> {
      List<Phone> phones = service.getPhones(user);
      System.out.println(user.getName() + " " + phones);
    });
    System.out.println("-----------------------------------------");
  }

  private static List<User> generateUsers() {
    List<User> users = new ArrayList<>();
    for (int i = 1; i <= 2; i++) {
      User user = new User();
      user.setName("User " + i);
      List<Phone> phones = new ArrayList<>();
      for (int j = 1; j <= 3; j++) {
        Phone phone = new Phone();
        phone.setUser(user);
        phone.setNumber("+7(909)347-22-" + i + j);
        phones.add(phone);
      }
      user.setPhones(phones);
      users.add(user);
    }
    return users;
  }
}
