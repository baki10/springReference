package com.bakigoal.dao.entity;

import com.bakigoal.dao.base.LongIdentifiedEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by ilmir on 06.07.16.
 */
@Entity
public class Phone extends LongIdentifiedEntity {

  private String number;
  private User user;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  @ManyToOne
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return number;
  }
}
