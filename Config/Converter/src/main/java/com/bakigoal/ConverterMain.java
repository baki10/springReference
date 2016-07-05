package com.bakigoal;

import com.bakigoal.service.MyService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by ilmir on 05.07.16.
 */
public class ConverterMain {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});

    MyService myService = context.getBean(MyService.class);
    System.out.println(myService.convertStringToDouble("123"));
    System.out.println(myService.convertStringsToList(new String[]{"123", "312", "321"}));
    System.out.println(myService.convertDateToLong(new Date()));

    System.out.println("Available converters: " + myService);

    context.registerShutdownHook();
  }
}
