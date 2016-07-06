package com.bakigoal.dao.entity;

import com.bakigoal.dao.base.VersionedEntity;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by ilmir on 06.07.16.
 */
@Entity
public class Product extends VersionedEntity {

  private String name;
  private String description;
  private BigDecimal price;
  private String category;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "Product{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", category='" + category + '\'' +
        "} " + super.toString();
  }
}
