package com.bakigoal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ilmir on 05.07.16.
 */
@Service
public class MyService {

  private final ConversionService conversionService;

  @Autowired
  public MyService(ConversionService conversionService) {
    this.conversionService = conversionService;
  }

  public Double convertStringToDouble(String s) {
    return this.conversionService.convert(s, Double.class);
  }

  public List convertStringsToList(String[] s) {
    return this.conversionService.convert(s, List.class);
  }

  public Long convertDateToLong(Date date) {
    boolean canConvert = conversionService.canConvert(Date.class, Long.class);
    return canConvert ? this.conversionService.convert(date, Long.class) : null;
  }

  @Override
  public String toString() {
    return conversionService.toString();
  }
}
