package com.bakigoal.service;

import com.bakigoal.dao.entity.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public interface ProductService {
  List<Product> getProducts();

  void addProduct(Product product);

  void removeProduct(Product product);

  void increasePriceOfAllProductsInCategory(final String category, BigDecimal delta);
}
