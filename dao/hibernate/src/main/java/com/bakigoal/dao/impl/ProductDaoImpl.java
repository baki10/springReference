package com.bakigoal.dao.impl;

import com.bakigoal.dao.ProductDao;
import com.bakigoal.dao.base.BaseDao;
import com.bakigoal.dao.entity.Product;
import org.hibernate.query.Query;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public final class ProductDaoImpl extends BaseDao<Product> implements ProductDao {

  public ProductDaoImpl() {
    super(Product.class);
  }

  @Override
  public List<Product> productsByCategory(String category) {
    Query query = getSession().createQuery("from Product p where p.category = :category");
    query.setParameter("category", category);
    return query.list();
  }
}
