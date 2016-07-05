package com.bakigoal.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

/**
 * Created by ilmir on 04.07.16.
 */
@Aspect
public class EmployeeAspectJoinPoint {

  @Before("execution(public void com.bakigoal.spring.model..set*(*))")
  public void loggingAdvice(JoinPoint joinPoint) {
    System.out.println("EmployeeAspectJoinPoint :: Before running loggingAdvice on method=" + joinPoint.toString());

    System.out.println("EmployeeAspectJoinPoint :: Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));

  }

  //Advice arguments, will be applied to bean methods with single String argument
  @Before("args(name)")
  public void logStringArguments(String name) {
    System.out.println("EmployeeAspectJoinPoint :: String argument passed=" + name);
  }
}
