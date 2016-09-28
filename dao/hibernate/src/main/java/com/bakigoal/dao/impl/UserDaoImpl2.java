package com.bakigoal.dao.impl;

import com.bakigoal.dao.UserDao;
import com.bakigoal.dao.entity.Phone;
import com.bakigoal.dao.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Repository("userDao2")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public final class UserDaoImpl2 extends HibernateDaoSupport implements UserDao {

  @Autowired
  public void sFactory(SessionFactory sessionFactory) {
    setSessionFactory(sessionFactory);
  }

  @Override
  public List<User> getAll() {
    System.out.println("dao------getAll-----");
    return getHibernateTemplate().loadAll(User.class);
  }

  @Override
  public User load(Serializable id) {
    return getHibernateTemplate().load(User.class, id);
  }

  @Override
  public User findById(Serializable id) {
    return getHibernateTemplate().get(User.class, id);
  }

  @Override
  public void remove(Serializable id) {
    if (id == null) {
      return;
    }
    User byId = findById(id);
    if (byId == null) {
      return;
    }
    getHibernateTemplate().delete(byId);
  }

  @Override
  public void update(Object obj) {
    getHibernateTemplate().update(obj);
  }

  @Override
  public void flush() {
    getHibernateTemplate().flush();
  }

  @Override
  public Class<User> getType() {
    return User.class;
  }

  @Override
  public Serializable save(Object obj) {
    return getHibernateTemplate().save(obj);
  }

  @Override
  public List usersByName(String name) {
    return getSessionFactory().getCurrentSession().createQuery("from User u where u.name = :name")
        .setParameter("name", name).list();
  }

  @Override
  public List<Phone> getPhones(User user) {
    if (user == null) {
      return Collections.emptyList();
    }
    return getSessionFactory().getCurrentSession()
        .createQuery("from Phone p where (p.user is not null) and (p.user.id = :userId)", Phone.class)
        .setParameter("userId", user.getId()).list();
  }
}
