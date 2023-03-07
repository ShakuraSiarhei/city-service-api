package com.logistic.test.cityservice.api.services;

import com.logistic.test.cityservice.api.dtos.CityCriteria;
import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;

public interface CityService {

  PageResponse<CityResponse> getAllCities(Integer page, Integer size);

  void updateCity(CityRequest cityRequest);

  PageResponse<CityResponse> searchCityByName(Integer page, Integer size, CityCriteria criteria);
}
