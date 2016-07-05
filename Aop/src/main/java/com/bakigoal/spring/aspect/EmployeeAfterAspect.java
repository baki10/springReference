package com.bakigoal.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by ilmir on 04.07.16.
 */
@Aspect
public class EmployeeAfterAspect {

  @After("args(name)")
  public void logStringArguments(String name) {
    System.out.println("EmployeeAfterAspect :: Running After Advice. String argument passed=" + name);
  }

  @AfterThrowing("within(com.bakigoal.spring.model.Employee)")
  public void logExceptions(JoinPoint joinPoint) {
    System.out.println("EmployeeAfterAspect :: Exception thrown in Employee Method=" + joinPoint.toString());
  }

  @AfterReturning(pointcut = "execution(* getName())", returning = "returnString")
  public void getNameReturningAdvice(String returnString) {
    System.out.println("EmployeeAfterAspect :: getNameReturningAdvice executed. Returned String=" + returnString);
  }

}
