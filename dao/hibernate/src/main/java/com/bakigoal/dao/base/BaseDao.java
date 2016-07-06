package com.bakigoal.dao.base;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ilmir on 02.06.16.
 */
public class BaseDao<E extends Identified> extends AbstractDao implements Dao<E>, EntityClassConsumer {
  private Class<E> entityClass;

  public BaseDao(Class<E> entityClass) {
    init(entityClass);
  }

  protected final void init(Class<E> entityClass) {
    this.entityClass = entityClass;
  }

  @Override
  public List<E> getAll() {
    return createBaseCriteria().list();
  }

  @Override
  public E load(Serializable id) {
    return load(entityClass, id);
  }

  @Override
  public E findById(Serializable id) {
    return findById(entityClass, id);
  }

  @Override
  public void remove(Serializable id) {
    remove(load(id));
  }

  public void remove(E entity) {
    getSession().delete(entity);
  }

  @Override
  public Criteria createBaseCriteria() {
    return getSession().createCriteria(getType());
  }

  public Class<E> getType() {
    return entityClass;
  }

  @Override
  public void setEntityClass(Class<? extends IdentifiedEntity> entityClass) {
    init((Class<E>) entityClass);
  }

  @Override
  public Class<? extends IdentifiedEntity> getEntityClass() {
    return (Class<? extends IdentifiedEntity>) getType();
  }
}
