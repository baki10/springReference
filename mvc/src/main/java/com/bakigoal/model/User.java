package com.bakigoal.model;

import org.springframework.stereotype.Component;

/**
 * Created by ilmir on 11.07.16.
 */
@Component
public class User {
  private String firstName;
  private String lastName;
  private String sex;
  private String password;
  private String country;
  private String notes;

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "User{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", sex='" + sex + '\'' +
        ", password='" + password + '\'' +
        ", country='" + country + '\'' +
        ", notes='" + notes + '\'' +
        '}';
  }
}
