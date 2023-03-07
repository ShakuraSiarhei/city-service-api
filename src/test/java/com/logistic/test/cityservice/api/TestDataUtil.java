package com.logistic.test.cityservice.api;

import com.logistic.test.cityservice.api.dtos.CityCriteria;
import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;
import com.logistic.test.cityservice.api.entities.City;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataUtil {

  private final Long ID = 1L;
  private final String CITY_NAME = "Test City Name";
  private final String CITY_PHOTO = "Test city photo url";
  private final String NEW_CITY_NAME = "New test city name";
  private final String NEW_CITY_PHOTO_URL = "https://upload.wikimedia.org/newurl";
  private final String INVALID_CITY_PHOTO_URL = "newurl";
  private final Integer PAGE = 15;
  private final Integer SIZE = 2;

  public static City getCity() {
    return City.builder()
        .id(ID)
        .name(CITY_NAME)
        .photo(CITY_PHOTO)
        .build();
  }

  public static CityResponse getCityResponse() {
    return CityResponse.builder()
        .id(ID)
        .name(CITY_NAME)
        .photo(CITY_PHOTO)
        .build();
  }

  public static Integer getPage() {
    return PAGE;
  }

  public static Integer getSize() {
    return SIZE;
  }

  public static PageResponse<CityResponse> getPageResponse() {
    return PageResponse.<CityResponse>builder()
        .pages(PAGE)
        .size(SIZE)
        .content(List.of(getCityResponse()))
        .build();
  }

  public static CityCriteria getCityCriteria() {
    return CityCriteria.builder()
        .searchValue(CITY_NAME)
        .build();
  }

  public static CityCriteria getCityCriteriaWithNullValue() {
    return CityCriteria.builder()
        .searchValue(null)
        .build();
  }

  public static CityRequest getCityRequest() {
    return CityRequest.builder()
        .id(ID)
        .newName(NEW_CITY_NAME)
        .newPhoto(NEW_CITY_PHOTO_URL)
        .build();
  }

  public static CityRequest getCityRequestWithNullName() {
    return CityRequest.builder()
        .id(null)
        .newName(NEW_CITY_NAME)
        .newPhoto(NEW_CITY_PHOTO_URL)
        .build();
  }

  public static CityRequest getCityRequestWithEmptyNewName() {
    return CityRequest.builder()
        .id(ID)
        .newName("")
        .newPhoto(NEW_CITY_PHOTO_URL)
        .build();
  }

  public static CityRequest getCityRequestWithNullNewName() {
    return CityRequest.builder()
        .id(ID)
        .newName(null)
        .newPhoto(NEW_CITY_PHOTO_URL)
        .build();
  }

  public static CityRequest getCityRequestWithInvalidUrl() {
    return CityRequest.builder()
        .id(ID)
        .newName(NEW_CITY_NAME)
        .newPhoto(INVALID_CITY_PHOTO_URL)
        .build();
  }
}
