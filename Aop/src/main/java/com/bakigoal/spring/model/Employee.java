package com.bakigoal.spring.model;

import com.bakigoal.spring.aspect.Loggable;

/**
 * Created by ilmir on 04.07.16.
 */
public class Employee {

  private String name;

  public String getName() {
    return name;
  }

  @Loggable
  public void setName(String name) {
    this.name = name;
  }

  public void throwException(){
    throw new RuntimeException("Dummy Exception");
  }
}
