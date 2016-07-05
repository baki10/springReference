package com.bakigoal.service;

import com.bakigoal.model.Movie;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public interface MovieService {
  List<Movie> getMovies();

  @PostConstruct
  default void init() {
    System.out.println("------ init ------" + this.getClass());
  }

  @PreDestroy
  default void destroy() {
    System.out.println("------ destroy ------" + this.getClass());
  }
}
