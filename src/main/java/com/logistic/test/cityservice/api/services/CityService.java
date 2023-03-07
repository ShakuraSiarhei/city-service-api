package com.logistic.test.cityservice.api.services;

import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;

public interface CityService {

  PageResponse<CityResponse> getCities(Integer page, Integer size, String cityName);

  void updateCity(CityRequest cityRequest);
}
