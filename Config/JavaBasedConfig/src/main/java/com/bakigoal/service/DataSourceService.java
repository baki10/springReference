package com.bakigoal.service;

/**
 * Created by ilmir on 05.07.16.
 */
public class DataSourceService {
  private String name;

  public DataSourceService(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "=== DataSourceService {" +
        "name='" + name + '\'' +
        " } ===";
  }
}
