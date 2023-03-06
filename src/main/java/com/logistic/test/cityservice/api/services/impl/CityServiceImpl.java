package com.logistic.test.cityservice.api.services.impl;

import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;
import com.logistic.test.cityservice.api.entities.City;
import com.logistic.test.cityservice.api.exceptions.NotFoundException;
import com.logistic.test.cityservice.api.mappers.CityMapper;
import com.logistic.test.cityservice.api.repositories.CityRepository;
import com.logistic.test.cityservice.api.services.CityService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;
  private final CityMapper cityMapper;

  @Override
  @Transactional(readOnly = true)
  public PageResponse<CityResponse> getAllCities(Pageable pageable) {
    Page<City> cities = cityRepository.findAll(pageable);
    List<CityResponse> citiesResponse = cityMapper.toCityResponseList(cities.getContent());

    return PageResponse.<CityResponse>builder()
        .content(citiesResponse)
        .total(cities.getTotalElements())
        .pages(cities.getTotalPages())
        .size(cities.getSize())
        .build();
  }

  @Override
  public CityResponse getByName(String cityName) {
    City city = getCityByName(cityName);
    return cityMapper.toCityResponse(city);
  }

  @Override
  @Transactional
  public void updateCity(CityRequest cityRequest) {
    City city = getCityByName(cityRequest.getCurrentName());
    City cityToSave = cityMapper.updateEntity(cityRequest, city);

    cityRepository.save(cityToSave);
  }

  private City getCityByName(String name) {
    return cityRepository.getCityByName(name).orElseThrow(
        () -> new NotFoundException(String.format("City named %s not found.", name)));
  }
}
