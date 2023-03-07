package com.logistic.test.cityservice.api.services.impl;

import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;
import com.logistic.test.cityservice.api.entities.City;
import com.logistic.test.cityservice.api.mappers.CityMapper;
import com.logistic.test.cityservice.api.repositories.CityRepository;
import com.logistic.test.cityservice.api.services.CityService;
import com.logistic.test.cityservice.api.util.CitySpecification;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityNotFoundException;
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
  public PageResponse<CityResponse> getCities(Integer page, Integer size, String cityName) {
    PageRequest pageable = getPageRequest(page, size);
    Page<City> cities = getCitiesPage(pageable, cityName);
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
        () -> new EntityNotFoundException(
            String.format("City with id #%s not found.", cityRequest.getId())));
    City cityToSave = cityMapper.updateEntity(cityRequest, city);

    cityRepository.save(cityToSave);
  }

  private Page<City> getCitiesPage(PageRequest pageable, String cityName) {
    if (Objects.nonNull(cityName)) {
      Specification<City> specification = CitySpecification.getSpecification(cityName);
      return cityRepository.findAll(specification, pageable);
    }
    return cityRepository.findAll(pageable);
  }

  private PageRequest getPageRequest(Integer page, Integer size) {
    return PageRequest.of(page, size);
  }
}
