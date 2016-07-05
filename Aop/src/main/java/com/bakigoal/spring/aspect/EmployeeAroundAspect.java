package com.bakigoal.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by ilmir on 04.07.16.
 */
@Aspect
public class EmployeeAroundAspect {

  @Around("execution(* com.bakigoal.spring.model.Employee.getName())")
  public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
    System.out.println("EmployeeAroundAspect :: Before invoking getName() method");
    Object value = null;
    try {
      value = proceedingJoinPoint.proceed();
    } catch (Throwable e) {
      System.err.println("error "+e.getMessage());
    }
    System.out.println("EmployeeAroundAspect :: After invoking getName() method. Return value=" + value);
    return value;
  }

  @Around("execution(* com.bakigoal.spring.model.Employee.setAge(int))")
  public Object employeeSetAgeAround(ProceedingJoinPoint proceedingJoinPoint) {
    System.out.println();
    System.out.println("EmployeeAroundAspect :: Before invoking setAge() method. Argument = " + proceedingJoinPoint.getArgs()[0]);
    Object proceed = null;
    try {
      System.out.println("EmployeeAroundAspect :: Argument changed to 12");
      proceed = proceedingJoinPoint.proceed(new Object[]{12});
    } catch (Throwable e) {
      System.err.println("error "+e.getMessage());
    }
    System.out.println("EmployeeAroundAspect :: After invoking setAge() method.");
    System.out.println();
    return proceed;
  }
}
