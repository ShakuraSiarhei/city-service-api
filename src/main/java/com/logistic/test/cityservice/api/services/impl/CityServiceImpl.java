package com.logistic.test.cityservice.api.services.impl;

import com.logistic.test.cityservice.api.dtos.CityCriteria;
import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;
import com.logistic.test.cityservice.api.entities.City;
import com.logistic.test.cityservice.api.exceptions.NotFoundException;
import com.logistic.test.cityservice.api.mappers.CityMapper;
import com.logistic.test.cityservice.api.repositories.CityRepository;
import com.logistic.test.cityservice.api.services.CityService;
import com.logistic.test.cityservice.api.util.CitySpecification;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;
  private final CityMapper cityMapper;

  @Override
  @Transactional(readOnly = true)
  public PageResponse<CityResponse> getAllCities(Integer page, Integer size) {
    PageRequest pageable = getPageRequest(page, size);
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
  @Transactional
  public void updateCity(CityRequest cityRequest) {
    City city = cityRepository.findById(cityRequest.getId()).orElseThrow(
        () -> new NotFoundException(
            String.format("City with id #%s not found.", cityRequest.getId())));
    City cityToSave = cityMapper.updateEntity(cityRequest, city);

    cityRepository.save(cityToSave);
  }

  @Override
  public PageResponse<CityResponse> searchCityByName(Integer page, Integer size,
      CityCriteria criteria) {
    Specification<City> specification = CitySpecification.getSpecification(
        criteria.getSearchValue());
    PageRequest pageable = getPageRequest(page, size);

    Page<City> cities = cityRepository.findAll(specification, pageable);
    List<CityResponse> citiesResponse = cityMapper.toCityResponseList(cities.getContent());

    return PageResponse.<CityResponse>builder()
        .content(citiesResponse)
        .total(cities.getTotalElements())
        .pages(cities.getTotalPages())
        .size(cities.getSize())
        .build();
  }

  private PageRequest getPageRequest(Integer page, Integer size) {
    return PageRequest.of(page, size);
  }
}
