package com.bakigoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ilmir on 11.07.16.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

  @GetMapping
  public String login() {
    return "login/login";
  }

  @GetMapping("/failed")
  public String error(Model model) {
    model.addAttribute("error", "true");
    return "login/login";
  }

  @GetMapping("/logout")
  public String logout(Model model) {
    return "redirect:/login";
  }
}
