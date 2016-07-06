package com.bakigoal;

import com.bakigoal.model.Movie;
import com.bakigoal.service.MovieService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public class JdbcMain {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});


    MovieService movieQualifierService = context.getBean(MovieService.class);
    printUsers(movieQualifierService);

    context.registerShutdownHook();
  }

  private static void printUsers(MovieService movieService) {
    System.out.println("add movies:");
    Movie newMovie1 = new Movie();
    newMovie1.setYear(2014);
    newMovie1.setName("Hulk1");
    newMovie1.setAuthor("McArthur");
    movieService.addMovie(newMovie1);

    Movie newMovie2 = new Movie();
    newMovie2.setYear(2015);
    newMovie2.setName("Hulk2");
    newMovie2.setAuthor("McArthur");
    movieService.addMovie(newMovie2);

    Movie newMovie3 = new Movie();
    newMovie3.setYear(2016);
    newMovie3.setName("Hulk3");
    newMovie3.setAuthor("McArthur");
    movieService.addMovie(newMovie3);

    System.out.println("get all movies");
    for (Movie movie : movieService.getMovies()) {
      System.out.println(movie);
    }

    List<Movie> movies = movieService.getMovies();
    System.out.println("find by id: " + movies.get(0).getId());
    Movie byId = movieService.findById(movies.get(0).getId());
    System.out.println(byId);

    System.out.println("edit movie with id: " + byId.getId());
    byId.setName("Edited name");
    byId.setAuthor("Edited author");
    byId.setYear(1999);
    movieService.update(byId);
    System.out.println(movieService.findById(byId.getId()));


    System.out.println("get all movies");
    for (Movie movie : movieService.getMovies()) {
      System.out.println(movie);
    }

    System.out.println("batch update all movies:");
    List<Movie> movies1 = new ArrayList<>(movieService.getMovies());
    for (Movie movie : movies1) {
      movie.setName("Batch Update " + movie.getId());
    }
    movieService.batchUpdate(movies1);
    for (Movie movie : movieService.getMovies()) {
      System.out.println(movie);
    }

    System.out.println("remove movies:");
    for (Movie movie : movieService.getMovies()) {
      movieService.removeMovie(movie);
    }
    System.out.println("get all movies");
    for (Movie movie : movieService.getMovies()) {
      System.out.println(movie);
    }
  }
}
