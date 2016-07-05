package com.bakigoal.service.impl;

import com.bakigoal.model.User;
import com.bakigoal.service.UserService;
import org.springframework.stereotype.Service;

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

  @Override
  public User findByFirstName(String name) {
    if (name == null) {
      return null;
    }
    for (User user : users) {
      if (name.equals(user.getFirstName())) {
        return user;
      }
    }
    return null;
  }
}
