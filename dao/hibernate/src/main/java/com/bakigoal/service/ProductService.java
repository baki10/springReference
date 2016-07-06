package com.bakigoal.service;

import com.bakigoal.dao.entity.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public interface ProductService {
  List<Product> getProducts();

  Product addProduct(Product product);

  void removeProduct(Product product);

  void removeProduct(Long id);

  void increasePriceOfAllProductsInCategory(final String category, BigDecimal delta);

  Product getProductById(Long id);

  void updateProduct(Product product);
}
