package com.logistic.test.cityservice.api.repositories;

import com.logistic.test.cityservice.api.entities.City;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends AbstractRepository<City>, JpaSpecificationExecutor<City> {

}
