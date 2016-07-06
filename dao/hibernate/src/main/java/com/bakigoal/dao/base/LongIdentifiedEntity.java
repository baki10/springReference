package com.bakigoal.dao.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by ilmir on 03.06.16.
 */
@MappedSuperclass
public class LongIdentifiedEntity extends IdentifiedEntity {

  private Long id;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
