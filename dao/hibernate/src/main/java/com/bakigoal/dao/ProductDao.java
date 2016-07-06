package com.bakigoal.dao;

import com.bakigoal.dao.base.Dao;
import com.bakigoal.dao.entity.Product;

import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public interface ProductDao extends Dao<Product> {

  List<Product> productsByCategory(String category);
  //here goes some Product dao specific methods
}
