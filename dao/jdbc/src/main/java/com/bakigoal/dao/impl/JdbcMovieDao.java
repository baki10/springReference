package com.bakigoal.dao.impl;

import com.bakigoal.dao.MovieDao;
import com.bakigoal.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
@Repository
public class JdbcMovieDao implements MovieDao {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcMovieDao(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  private static final class MovieMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
      Movie m = new Movie();
      m.setId(resultSet.getInt("id"));
      m.setName(resultSet.getString("name"));
      m.setAuthor(resultSet.getString("author"));
      m.setYear(resultSet.getInt("year"));
      return m;
    }
  }

  public List<Movie> getMovies() {
    return this.jdbcTemplate.query("select * from movie", new MovieMapper());
  }

  @Override
  public Movie findById(int id) {
    return this.jdbcTemplate.queryForObject(
        "select * from movie where id = ?", new Object[]{id}, new MovieMapper());
  }

  @Override
  public void removeMovie(int id) {
    this.jdbcTemplate.update(
        "delete from movie where id = ?",
        id);
  }

  @Override
  public void addMovie(Movie movie) {
    if (movie == null) {
      return;
    }
    this.jdbcTemplate.update(
        "insert into movie (name, author, year) values (?, ?, ?)",
        movie.getName(), movie.getAuthor(), movie.getYear());
  }

  @Override
  public void update(Movie movie) {
    this.jdbcTemplate.update(
        "update movie set name = ?, author = ?, year = ? where id = ?",
        movie.getName(), movie.getAuthor(), movie.getYear(), movie.getId());
  }

  @Override
  public int[] batchUpdate(final List<Movie> movies) {
    int[] updateCounts = jdbcTemplate.batchUpdate(
        "update movie set name = ?, author = ?, year = ? where id = ?",
        new BatchPreparedStatementSetter() {

          public void setValues(PreparedStatement ps, int i) throws SQLException {
            Movie movie = movies.get(i);
            ps.setString(1, movie.getName());
            ps.setString(2, movie.getAuthor());
            ps.setInt(3, movie.getYear());
            ps.setInt(4, movie.getId());
          }

          public int getBatchSize() {
            return movies.size();
          }
        });
    return updateCounts;
  }
}
