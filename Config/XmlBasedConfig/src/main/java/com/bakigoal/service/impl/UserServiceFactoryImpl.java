package com.bakigoal.service.impl;

import com.bakigoal.model.User;
import com.bakigoal.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public class UserServiceFactoryImpl implements UserService {

  private static UserServiceFactoryImpl instance = new UserServiceFactoryImpl();

  private List<User> users = new ArrayList<>();

  public static UserServiceFactoryImpl getInstance(){
    return instance;
  }

  private UserServiceFactoryImpl() {
    for (int i = 1; i < 4; i++) {
      User user = new User();
      user.setFirstName("Factory Name " + i);
      user.setLastName("Factory Surname " + i);
      user.setAge(31 + i);

      users.add(user);
    }
  }

  @Override
  public List<User> getUsers() {
    return users;
  }
}
