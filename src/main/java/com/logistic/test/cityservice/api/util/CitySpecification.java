package com.logistic.test.cityservice.api.util;

import com.logistic.test.cityservice.api.entities.City;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class CitySpecification {

  public Specification<City> getSpecification(String name) {
    return (root, query, criteriaBuilder) -> {
      final List<Predicate> andConditions = new ArrayList<>();

      andConditions.add(criteriaBuilder.equal(root.get("name"), name));

      return criteriaBuilder.and(andConditions.toArray(new Predicate[0]));
    };
  }

}
