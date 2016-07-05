package com.bakigoal;

import com.bakigoal.config.AppConfig;
import com.bakigoal.model.Movie;
import com.bakigoal.service.MovieService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ilmir on 05.07.16.
 */
public class JavaMain {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

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
