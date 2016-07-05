package com.bakigoal;

import com.bakigoal.model.Movie;
import com.bakigoal.service.MovieService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ilmir on 05.07.16.
 */
public class AnnotationMain {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});


    MovieService movieQualifierService = context.getBean(MovieService.class);
    printUsers(movieQualifierService, "!!! MovieDao: !!!");

    context.registerShutdownHook();
  }

  private static void printUsers(MovieService movieService, String caption) {
    System.out.println(caption);
    for (Movie movie : movieService.getMovies()) {
      System.out.println(movie);
    }
  }
}
