package com.bakigoal.mail;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by ilmir on 11.07.16.
 */
public class SimpleMailManager implements MailManager {

  private MailSender mailSender;
  private SimpleMailMessage templateMessage;

  public void setMailSender(MailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void setTemplateMessage(SimpleMailMessage templateMessage) {
    this.templateMessage = templateMessage;
  }

  @Override
  public void sendMessage(Message message) {
    SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
    msg.setTo(message.getCustomerEmailAddress());
    msg.setText(
        "Dear " + message.getCustomerName() + " \n\t" + message.getText());
    try {
      this.mailSender.send(msg);
    } catch (MailException ex) {
      // simply log it and go on...
      System.err.println(ex.getMessage());
    }
  }
}
