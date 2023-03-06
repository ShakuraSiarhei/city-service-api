package com.logistic.test.cityservice.api.services;

import com.logistic.test.cityservice.api.dtos.CityCriteria;
import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;
import org.springframework.data.domain.Pageable;

public interface CityService {

  PageResponse<CityResponse> getAllCities(Pageable pageable);

  void updateCity(CityRequest cityRequest);

  PageResponse<CityResponse> searchCityByName(Pageable pageable, CityCriteria criteria);
}
