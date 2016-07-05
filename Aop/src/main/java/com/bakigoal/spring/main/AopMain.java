package com.bakigoal.spring.main;

import com.bakigoal.spring.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ilmir on 04.07.16.
 */
public class AopMain {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
    System.out.println(employeeService.getEmployee().getName());
    employeeService.getEmployee().setName("Ilmir");
//    employeeService.getEmployee().throwException();
    employeeService.getEmployee().setAge(28);

    int age = employeeService.getEmployee().getAge();
    System.out.println("\n after setAge(28); getAge() = " + age);
    ctx.close();
  }
}
