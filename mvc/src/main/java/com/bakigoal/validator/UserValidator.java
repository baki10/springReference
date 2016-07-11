package com.bakigoal.validator;

import com.bakigoal.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by ilmir on 11.07.16.
 */
@Component
public class UserValidator implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    return User.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required", "Field is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "required", "Field is required.");
  }
}
