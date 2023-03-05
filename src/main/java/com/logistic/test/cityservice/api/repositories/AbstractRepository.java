package com.logistic.test.cityservice.api.repositories;

import com.logistic.test.cityservice.api.entities.AbstractEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AbstractRepository<T extends AbstractEntity> extends
    PagingAndSortingRepository<T, Long> {

}
