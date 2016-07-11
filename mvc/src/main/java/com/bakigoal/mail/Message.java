package com.bakigoal.mail;

/**
 * Created by ilmir on 11.07.16.
 */
public class Message {

  private String customerEmailAddress;
  private String customerName;
  private String text;

  public void setCustomerEmailAddress(String customerEmailAddress) {
    this.customerEmailAddress = customerEmailAddress;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getCustomerEmailAddress() {
    return customerEmailAddress;
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return "Message{" +
        "customerEmailAddress='" + customerEmailAddress + '\'' +
        ", customerName='" + customerName + '\'' +
        ", text='" + text + '\'' +
        '}';
  }
}
