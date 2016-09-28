package com.bakigoal.dao.entity;

import com.bakigoal.dao.base.LongIdentifiedEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by ilmir on 02.06.16.
 */
@Entity
@Table(name = "users")
public class User extends LongIdentifiedEntity {

  private String name;
  private List<Phone> phones;

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }
}
