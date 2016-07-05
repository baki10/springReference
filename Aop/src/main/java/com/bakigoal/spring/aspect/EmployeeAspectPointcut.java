package com.bakigoal.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by ilmir on 04.07.16.
 */
@Aspect
public class EmployeeAspectPointcut {

  @Pointcut("execution(public String getName())")
  public void getNamePointcut(){}

  @Before("getNamePointcut()")
  public void loggingAdvice(){
    System.out.println("EmployeeAspectPointcut :: Executing loggingAdvice on getName()");
  }

  @Before("getNamePointcut()")
  public void secondAdvice(){
    System.out.println("EmployeeAspectPointcut :: Executing secondAdvice on getName()");
  }

  @Pointcut("within(com.bakigoal.spring.service.*)")
  public void allMethodsPointcut(){}

  @Before("allMethodsPointcut()")
  public void allServiceMethodsAdvice(){
    System.out.println("EmployeeAspectPointcut :: Before executing service method");
  }
}
