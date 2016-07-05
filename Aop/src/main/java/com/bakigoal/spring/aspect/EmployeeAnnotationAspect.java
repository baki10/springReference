package com.bakigoal.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by ilmir on 04.07.16.
 */
@Aspect
public class EmployeeAnnotationAspect {

  @Before("@annotation(com.bakigoal.spring.aspect.Loggable)")
  public void myAdvice(){
    System.out.println("EmployeeAnnotationAspect :: Executing myAdvice!!");
  }
}
