package com.bakigoal;

import com.bakigoal.config.AppConfig;
import com.bakigoal.model.Movie;
import com.bakigoal.service.MovieService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ilmir on 05.07.16.
 */
public class JavaMain {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(AppConfig.class);
//    context.scan("com.bakigoal.dao");
    context.refresh();

    MovieService movieService = context.getBean(MovieService.class);
    printUsers(movieService, "!!! MovieDao: !!!");

    context.registerShutdownHook();
  }

  private static void printUsers(MovieService movieService, String caption) {
    System.out.println(caption);
    for (Movie movie : movieService.getMovies()) {
      System.out.println(movie);
    }
  }
}
