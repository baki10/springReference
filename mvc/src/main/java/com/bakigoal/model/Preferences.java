package com.bakigoal.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by ilmir on 11.07.16.
 */
@Component
public class Preferences {
  private boolean receiveNewsletter;
  private String[] interests;
  private String favouriteWord;

  public boolean isReceiveNewsletter() {
    return receiveNewsletter;
  }

  public void setReceiveNewsletter(boolean receiveNewsletter) {
    this.receiveNewsletter = receiveNewsletter;
  }

  public String[] getInterests() {
    return interests;
  }

  public void setInterests(String[] interests) {
    this.interests = interests;
  }

  public String getFavouriteWord() {
    return favouriteWord;
  }

  public void setFavouriteWord(String favouriteWord) {
    this.favouriteWord = favouriteWord;
  }

  @Override
  public String toString() {
    return "Preferences{" +
        "receiveNewsletter=" + receiveNewsletter +
        ", interests=" + Arrays.toString(interests) +
        ", favouriteWord='" + favouriteWord + '\'' +
        '}';
  }
}
