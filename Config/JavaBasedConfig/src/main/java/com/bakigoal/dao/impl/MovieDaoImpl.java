package com.bakigoal.dao.impl;

import com.bakigoal.dao.MovieDao;
import com.bakigoal.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
@Repository
public class MovieDaoImpl implements MovieDao {

  private List<Movie> movies = new ArrayList<>();

  public MovieDaoImpl() {
    for (int i = 1; i < 4; i++) {
      Movie movie = new Movie();
      movie.setName("Name " + i);
      movie.setAuthor("Author " + i);
      movie.setYear(2013 + i);

      movies.add(movie);
    }
  }

  public List<Movie> getMovies() {
    return movies;
  }
}
