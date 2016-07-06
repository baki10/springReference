package com.bakigoal.model;

/**
 * Created by ilmir on 05.07.16.
 */
public class Settings {

  private boolean fooEnabled;

  public boolean isFooEnabled() {
    return fooEnabled;
  }

  public void setFooEnabled(boolean fooEnabled) {
    this.fooEnabled = fooEnabled;
  }

  @Override
  public String toString() {
    return "Settings{" +
        "fooEnabled=" + fooEnabled +
        '}';
  }
}
