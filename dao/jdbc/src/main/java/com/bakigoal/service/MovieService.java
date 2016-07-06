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

  Movie findById(int id);

  void removeMovie(int id);

  void removeMovie(Movie movie);

  void addMovie(Movie movie);

  void update(Movie movie);

  int[] batchUpdate(final List<Movie> movies);
}
