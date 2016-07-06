package com.bakigoal.model;

/**
 * Created by ilmir on 05.07.16.
 */
public class Movie {
  private int id;
  private String name;
  private String author;
  private int year;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Movie{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", author='" + author + '\'' +
        ", year=" + year +
        '}';
  }
}
