package com.bakigoal.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by ilmir on 04.07.16.
 */
@Aspect
public class EmployeeAspect {

  @Before("execution(public String getName())")
  public void getNameAdvice(){
    System.out.println("EmployeeAspect :: Executing Advice on getName()");
  }

  @Before("execution(* com.bakigoal.spring.service.*.get*())")
  public void getAllAdvice(){
    System.out.println("EmployeeAspect :: Service method getter called");
  }
}
