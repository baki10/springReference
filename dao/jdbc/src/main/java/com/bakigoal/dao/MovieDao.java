package com.bakigoal.dao;

import com.bakigoal.model.Movie;

import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public interface MovieDao {

  List<Movie> getMovies();

  Movie findById(int id);

  void removeMovie(int id);

  void addMovie(Movie movie);

  void update(Movie movie);

  int[] batchUpdate(final List<Movie> movies);
}
