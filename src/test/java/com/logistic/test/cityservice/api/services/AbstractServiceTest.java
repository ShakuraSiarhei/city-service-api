package com.logistic.test.cityservice.api.services;

import com.logistic.test.cityservice.api.mappers.CityMapper;
import com.logistic.test.cityservice.api.repositories.CityRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
abstract class AbstractServiceTest {

  @Mock
  protected CityRepository cityRepository;
  @Mock
  protected CityMapper cityMapper;
}
