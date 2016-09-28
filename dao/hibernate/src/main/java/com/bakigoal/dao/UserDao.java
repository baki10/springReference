package com.bakigoal.dao;

import com.bakigoal.dao.base.Dao;
import com.bakigoal.dao.entity.Phone;
import com.bakigoal.dao.entity.User;

import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public interface UserDao extends Dao<User> {

  //here goes some Phone dao specific methods

  List usersByName(String name);

  List<Phone> getPhones(User user);
}
