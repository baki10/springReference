package com.bakigoal.controller;

import com.bakigoal.model.Preferences;
import com.bakigoal.model.User;
import com.bakigoal.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * Created by ilmir on 11.07.16.
 */
@Controller
@RequestMapping("/jspSample")
public class JspController {

  @Autowired
  private UserValidator validator;

  @InitBinder
  private void initBinder(WebDataBinder binder) {
    binder.setValidator(validator);
  }

  @RequestMapping()
  public String menu() {
    return "jsp/menu";
  }

  @GetMapping("/userForm")
  public String getSimpleForm(Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("countryList", Arrays.asList("England", "Russia", "Spain", "USA"));
    return "jsp/userForm";
  }

  @PostMapping("/userForm")
  public String actionSimpleForm(Model model, @Validated User user, BindingResult result) {
    if (result.hasErrors()) {
      return "jsp/userForm";
    }
    model.addAttribute("message", "Added: " + user);
    return "jsp/formResult";
  }

  @GetMapping("/checkboxForm")
  public String getForm(Model model) {
    model.addAttribute("preferences", new Preferences());
    return "jsp/checkboxForm";
  }

  @PostMapping("/checkboxForm")
  public String actionForm(Preferences preferences, Model model) {
    model.addAttribute("message", "Added: " + preferences);
    return "jsp/formResult";
  }
}
