package com.logistic.test.cityservice.api.controllers.impl;

import com.logistic.test.cityservice.api.controllers.CityController;
import com.logistic.test.cityservice.api.dtos.CityCriteria;
import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;
import com.logistic.test.cityservice.api.services.CityService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityControllerImpl implements CityController {

  private final CityService cityService;

  @Override
  @GetMapping
  public PageResponse<CityResponse> getAllCities(
      @RequestParam(defaultValue = "0") final Integer page,
      @RequestParam(defaultValue = "10") final Integer size
  ) {
    return cityService.getAllCities(page, size);
  }

  @Override
  @PostMapping("/search")
  public PageResponse<CityResponse> searchCityByName(
      @RequestParam(defaultValue = "0") final Integer page,
      @RequestParam(defaultValue = "10") final Integer size,
      @RequestBody @Valid CityCriteria criteria) {
    return cityService.searchCityByName(page, size, criteria);
  }

  @Override
  @PutMapping
  public void updateCity(@RequestBody @Valid CityRequest cityRequest) {
    cityService.updateCity(cityRequest);
  }
}
