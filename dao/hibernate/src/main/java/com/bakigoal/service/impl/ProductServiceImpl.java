package com.bakigoal.service.impl;

import com.bakigoal.dao.ProductDao;
import com.bakigoal.dao.SimpleDao;
import com.bakigoal.dao.entity.Product;
import com.bakigoal.service.ProductService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

  @Autowired
  private SimpleDao simpleDao;

  @Override
  @Transactional(readOnly = true)
  public List<Product> getProducts() {
    return productDao.getAll();
  }

  @Override
  @Transactional
  public void addProduct(Product product) {
    productDao.save(product);
  }

  @Override
  @Transactional
  public void increasePriceOfAllProductsInCategory(final String category, BigDecimal delta) {
    //we can use universal simpleDao setting appropriate entity class
    simpleDao.setEntityClass(Product.class);
    Criteria criteria = simpleDao.createBaseCriteria();
    criteria.add(Restrictions.eq("category", category));
    List<Product> list = criteria.list();

    list.stream().forEach(p -> {
      BigDecimal price = p.getPrice();
      if (price != null) {
        p.setPrice(price.add(price.multiply(delta).divide(new BigDecimal(100), 3, BigDecimal.ROUND_HALF_UP)));
        productDao.update(p);
      }
    });
  }

  @Override
  public void doExtra(Product product) {
    productDao.doSmthWithProduct(product);
  }
}