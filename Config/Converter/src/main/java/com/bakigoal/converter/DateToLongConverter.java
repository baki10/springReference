package com.bakigoal.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * Created by ilmir on 05.07.16.
 */
public class DateToLongConverter implements Converter<Date, Long> {

  @Override
  public Long convert(Date date) {
    return date.getTime();
  }
}
