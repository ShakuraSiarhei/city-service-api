package com.logistic.test.cityservice.api;

import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;
import com.logistic.test.cityservice.api.entities.City;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;

@UtilityClass
public class TestDataUtil {

  private final Long ID = 1L;
  private final String CITY_NAME = "Test City Name";
  private final String CITY_PHOTO = "Test city photo url";
  private final String NEW_CITY_NAME = "New test city name";
  private final String NEW_CITY_PHOTO_URL = "New city photo URL";
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

  public static PageRequest getPageRequest() {
    return PageRequest.of(PAGE, SIZE);
  }

  public static PageResponse<CityResponse> getPageResponse() {
    return PageResponse.<CityResponse>builder()
        .pages(PAGE)
        .size(SIZE)
        .content(List.of(getCityResponse()))
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
}
