package com.logistic.test.cityservice.api.services;

import static com.logistic.test.cityservice.api.TestDataUtil.getCity;
import static com.logistic.test.cityservice.api.TestDataUtil.getCityRequest;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.logistic.test.cityservice.api.services.impl.CityServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class CityServiceTest extends AbstractServiceTest {

  @InjectMocks
  private CityServiceImpl cityService;

  @Test
  void shouldSuccessUpdateCityByName() {
    //GIVEN
    when(cityRepository.findById(getCity().getId())).thenReturn(Optional.of(getCity()));
    when(cityMapper.updateEntity(getCityRequest(), getCity())).thenReturn(getCity());

    //WHEN
    cityService.updateCity(getCityRequest());

    //THEN
    verify(cityRepository).findById(getCity().getId());
    verify(cityMapper).updateEntity(getCityRequest(), getCity());
    verify(cityRepository).save(getCity());
  }
}
