package com.logistic.test.cityservice.api.services;

import static com.logistic.test.cityservice.api.TestDataUtil.getCity;
import static com.logistic.test.cityservice.api.TestDataUtil.getCityRequest;
import static com.logistic.test.cityservice.api.TestDataUtil.getCityResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.services.impl.CityServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class CityServiceTest extends AbstractServiceTest {

  @InjectMocks
  private CityServiceImpl cityService;

  @Test
  void shouldSuccessGetCityByName() {
    //GIVEN
    when(cityRepository.getCityByName(getCity().getName())).thenReturn(Optional.of(getCity()));
    when(cityMapper.toCityResponse(getCity())).thenReturn(getCityResponse());

    //WHEN
    CityResponse response = cityService.getByName(getCity().getName());

    //THEN
    verify(cityRepository).getCityByName(getCity().getName());
    verify(cityMapper).toCityResponse(getCity());
    assertEquals(getCity().getName(), response.getName());
  }

  @Test
  void shouldSuccessUpdateCityByName() {
    //GIVEN
    when(cityRepository.getCityByName(getCity().getName())).thenReturn(Optional.of(getCity()));
    when(cityMapper.updateEntity(getCityRequest(), getCity())).thenReturn(getCity());

    //WHEN
    cityService.updateCity(getCityRequest());

    //THEN
    verify(cityRepository).getCityByName(getCity().getName());
    verify(cityMapper).updateEntity(getCityRequest(), getCity());
    verify(cityRepository).save(getCity());
  }
}
