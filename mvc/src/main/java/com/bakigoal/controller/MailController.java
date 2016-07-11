package com.bakigoal.controller;

import com.bakigoal.mail.Message;
import com.bakigoal.mail.MailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ilmir on 11.07.16.
 */
@RequestMapping("/send_mail")
@Controller
public class MailController {

  @Autowired
  private MailManager mailManager;

  @GetMapping
  public String getForm(Model model){
    model.addAttribute("message", new Message());
    return "mail/mailForm";
  }

  @PostMapping
  public String actionForm(Message message, Model model){
    mailManager.sendMessage(message);
    model.addAttribute("message", message);
    return "mail/formResult";
  }
}
