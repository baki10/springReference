package com.bakigoal.service;

import com.bakigoal.dao.entity.Phone;
import com.bakigoal.dao.entity.User;

import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public interface UserPhoneService {
  List<User> getUsers();

  User addUser(User user);

  void removeUser(User user);

  void removeUser(Long id);

  User getUserById(Long id);

  void updateUser(User user);

  List<Phone> getPhones(User user);
}
