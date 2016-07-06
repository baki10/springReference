package com.bakigoal.service.impl;

import com.bakigoal.dao.ProductDao;
import com.bakigoal.dao.entity.Product;
import com.bakigoal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

  @Override
  @Transactional(readOnly = true)
  public List<Product> getProducts() {
    return productDao.getAll();
  }

  @Override
  @Transactional
  public Product addProduct(Product product) {
    Long id = (Long) productDao.save(product);
    product.setId(id);
    return product;
  }

  @Override
  @Transactional
  public void removeProduct(Product product) {
    if (product != null) {
      productDao.remove(product.getId());
    }
  }

  @Override
  @Transactional
  public void removeProduct(Long id) {
    if (id != null) {
      productDao.remove(id);
    }
  }

  @Override
  @Transactional
  public void increasePriceOfAllProductsInCategory(final String category, BigDecimal delta) {

    List<Product> list = productDao.productsByCategory(category);

    list.stream().forEach(p -> {
      BigDecimal price = p.getPrice();
      if (price != null) {
        p.setPrice(price.add(price.multiply(delta).divide(new BigDecimal(100), 3, BigDecimal.ROUND_HALF_UP)));
        productDao.update(p);
      }
    });
  }

  @Override
  @Transactional
  public Product getProductById(Long id) {
    return id == null ? null : productDao.findById(id);
  }

  @Override
  @Transactional
  public void updateProduct(Product product) {
    if (product != null) {
      productDao.update(product);
    }
  }
}
