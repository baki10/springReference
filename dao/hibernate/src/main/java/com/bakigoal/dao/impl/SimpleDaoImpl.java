package com.bakigoal.dao.impl;

import com.bakigoal.dao.SimpleDao;
import com.bakigoal.dao.base.BaseDao;
import com.bakigoal.dao.base.Identified;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("simpleDao")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public final class SimpleDaoImpl<Entity extends Identified> extends BaseDao<Entity> implements SimpleDao<Entity> {

  public SimpleDaoImpl() {
    super(null);
  }
}
