package com.logistic.test.cityservice.api.repositories;

import com.logistic.test.cityservice.api.entities.City;
import java.util.Optional;

public interface CityRepository extends AbstractRepository<City> {

  Optional<City> getCityByName(String name);
}
