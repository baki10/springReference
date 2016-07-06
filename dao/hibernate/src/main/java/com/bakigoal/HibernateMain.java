package com.bakigoal;

import com.bakigoal.dao.entity.Product;
import com.bakigoal.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public class HibernateMain {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});

    ProductService service = context.getBean(ProductService.class);

    addProducts(service);
    printProducts(service.getProducts());
    System.out.println("increasing odd category products' prices");
    service.increasePriceOfAllProductsInCategory("odd", BigDecimal.TEN);
    printProducts(service.getProducts());
    System.out.println("removing products");
//    service.getProducts().stream().forEach(service::removeProduct);
    System.out.println("----------------------------------------------");
    printProducts(service.getProducts());

    context.registerShutdownHook();
  }

  private static void printProducts(List<Product> products) {
    System.out.println("------------- All Products --------------");
    products.stream().forEach(System.out::println);
    System.out.println("-----------------------------------------");
  }

  private static void addProducts(ProductService service) {
    for (int i = 1; i < 4; i++) {
      Product product = new Product();
      product.setName("Book " + i);
      product.setPrice(new BigDecimal(i * 1000));
      product.setCategory(i % 2 == 0 ? "even" : "odd");
      product.setDescription("Description to book " + i);
      service.addProduct(product);
      System.out.println("adding product: " + product);
    }
  }
}
