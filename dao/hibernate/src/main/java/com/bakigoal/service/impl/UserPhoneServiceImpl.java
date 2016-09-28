package com.bakigoal.service.impl;

import com.bakigoal.dao.UserDao;
import com.bakigoal.dao.entity.Phone;
import com.bakigoal.dao.entity.User;
import com.bakigoal.service.UserPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
@Service
public class UserPhoneServiceImpl implements UserPhoneService {

  @Autowired
  private UserDao userDao;

  @Override
  @Transactional(readOnly = true)
  public List<User> getUsers() {
    return userDao.getAll();
  }

  @Override
  @Transactional
  public User addUser(User user) {
    Long id = (Long) userDao.save(user);
    user.setId(id);
    return user;
  }

  @Override
  @Transactional
  public void removeUser(User user) {
    if (user != null) {
      userDao.remove(user.getId());
    }
  }

  @Override
  @Transactional
  public void removeUser(Long id) {
    if (id != null) {
      userDao.remove(id);
    }
  }

  @Override
  public User getUserById(Long id) {
    return id == null ? null : userDao.findById(id);
  }

  @Override
  @Transactional
  public void updateUser(User user) {
    if (user == null) {
      return;
    }
    userDao.update(user);
  }

  @Override
  @Transactional
  public List<Phone> getPhones(User user) {
    if (user == null) {
      return Collections.emptyList();
    }
    return userDao.getPhones(user);
  }
}
