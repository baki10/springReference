package com.bakigoal.service.impl;

import com.bakigoal.dao.MovieDao;
import com.bakigoal.model.Movie;
import com.bakigoal.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieDao movieDao;

  public List<Movie> getMovies() {
    return movieDao.getMovies();
  }

  @Override
  public Movie findById(int id) {
    return movieDao.findById(id);
  }

  @Override
  public void removeMovie(int id) {
    movieDao.removeMovie(id);
  }

  @Override
  public void removeMovie(Movie movie) {
    if(movie == null){
      return;
    }
    movieDao.removeMovie(movie.getId());
  }

  @Override
  public void addMovie(Movie movie) {
    movieDao.addMovie(movie);
  }

  @Override
  public void update(Movie movie) {
    movieDao.update(movie);
  }

  @Override
  public int[] batchUpdate(List<Movie> movies) {
    return movieDao.batchUpdate(movies);
  }
}
