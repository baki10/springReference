package com.bakigoal.dao;

import com.bakigoal.model.Movie;

import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
public interface MovieDao {
  List<Movie> getMovies();
}
