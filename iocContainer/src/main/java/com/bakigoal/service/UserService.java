package com.bakigoal.service;

import com.bakigoal.model.User;

import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public interface UserService {
  List<User> getUsers();

  User findByFirstName(String name);
}
