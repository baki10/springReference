package com.bakigoal.dao.impl;

import com.bakigoal.dao.ProductDao;
import com.bakigoal.dao.entity.Product;
import com.bakigoal.dao.base.BaseDao;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("productDao")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public final class ProductDaoImpl extends BaseDao<Product> implements ProductDao {

  public ProductDaoImpl() {
    super(Product.class);
  }

  @Override
  public void doSmthWithProduct(Product product) {
    System.out.println("Doing something with product " + product);
  }
}
