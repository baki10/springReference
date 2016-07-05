package com.bakigoal.spring.service;

import com.bakigoal.spring.model.Employee;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ilmir on 04.07.16.
 */
public class EmployeeService implements InitializingBean, DisposableBean {

  private Employee employee;

  public Employee getEmployee(){
    return this.employee;
  }

  public void setEmployee(Employee e){
    this.employee=e;
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("!!! EmployeeService - destroy !!!");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("!!! EmployeeService - init !!!");
  }

  @PostConstruct
  public void init(){
    System.out.println("--- EmployeeService - @PostConstruct ---");
  }

  @PreDestroy
  public void preDestroy(){
    System.out.println("--- EmployeeService - @PreDestroy ---");
  }

  public void init2() {
    System.out.println("!!! EmployeeService - initXML !!!");
  }

  public void destroy2() {
    System.out.println("!!! EmployeeService - destroyXML !!!");
  }
}
