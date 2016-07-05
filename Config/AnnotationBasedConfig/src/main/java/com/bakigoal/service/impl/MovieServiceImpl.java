package com.bakigoal.service.impl;

import com.bakigoal.dao.MovieDao;
import com.bakigoal.model.Movie;
import com.bakigoal.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieDao movieDao;

  public List<Movie> getMovies() {
    return movieDao.getMovies();
  }
}
