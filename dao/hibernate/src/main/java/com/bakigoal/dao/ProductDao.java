package com.bakigoal.dao;

import com.bakigoal.dao.entity.Product;
import com.bakigoal.dao.base.Dao;

/**
 * Created by ilmir on 05.07.16.
 */
public interface ProductDao extends Dao<Product> {
  //here goes some Product dao specific methods
  void doSmthWithProduct(Product product);
}
