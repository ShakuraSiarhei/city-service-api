package com.logistic.test.cityservice.api.controllers.impl;

import com.logistic.test.cityservice.api.controllers.CityController;
import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;
import com.logistic.test.cityservice.api.services.CityService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityControllerImpl implements CityController {

  private final CityService cityService;

  @Override
  @GetMapping
  public PageResponse<CityResponse> getAllCities(
      @PageableDefault Pageable pageable
  ) {
    return cityService.getAllCities(pageable);
  }

  @Override
  @GetMapping("/{cityName}")
  public CityResponse getByName(
      @PathVariable String cityName) {
    return cityService.getByName(cityName);
  }

  @Override
  @PutMapping
  public void updateCity(@RequestBody @Valid CityRequest cityRequest) {
    cityService.updateCity(cityRequest);
  }
}
