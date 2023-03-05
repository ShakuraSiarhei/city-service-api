package com.logistic.test.cityservice.api.mappers;

import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.entities.City;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CityMapper {

  CityResponse toCityResponse(City entity);

  List<CityResponse> toCityResponseList(List<City> entities);

  @Mapping(target = "name", source = "newName")
  City updateEntity(CityRequest cityRequest, @MappingTarget City city);
}