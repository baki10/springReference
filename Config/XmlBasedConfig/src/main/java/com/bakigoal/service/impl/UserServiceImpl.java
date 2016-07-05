package com.bakigoal.service.impl;

import com.bakigoal.model.User;
import com.bakigoal.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public class UserServiceImpl implements UserService {

  private List<User> users = new ArrayList<>();

  public UserServiceImpl() {
    for (int i = 1; i < 4; i++) {
      User user = new User();
      user.setFirstName("Name " + i);
      user.setLastName("Surname " + i);
      user.setAge(20 + i);

      users.add(user);
    }
  }

  @Override
  public List<User> getUsers() {
    return users;
  }
}
