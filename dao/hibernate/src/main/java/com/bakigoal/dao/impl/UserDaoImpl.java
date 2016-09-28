package com.bakigoal.dao.impl;

import com.bakigoal.dao.UserDao;
import com.bakigoal.dao.base.BaseDao;
import com.bakigoal.dao.entity.Phone;
import com.bakigoal.dao.entity.User;
import org.hibernate.query.Query;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("userDao")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public final class UserDaoImpl extends BaseDao<User> implements UserDao {

  public UserDaoImpl() {
    super(User.class);
  }

  @Override
  public List<User> usersByName(String name) {
    Query query = getSession().createQuery("from User p where p.name = :name");
    query.setParameter("name", name);
    return query.list();
  }

  @Override
  public List<Phone> getPhones(User user) {
    if (user == null) {
      return Collections.emptyList();
    }
    return getSession()
        .createQuery("select p from Phone p inner join p.user u with u.id = :userId", Phone.class)
        .setParameter("userId", user.getId()).list();

  }

  @Override
  public List<User> getAll() {
    List<User> all = super.getAll();
    for (User user : all) {
      getSession().update(user);
    }
    return all;
  }
}
