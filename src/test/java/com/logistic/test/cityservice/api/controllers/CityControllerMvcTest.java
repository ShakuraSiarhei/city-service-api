package com.logistic.test.cityservice.api.controllers;

import static com.logistic.test.cityservice.api.TestDataUtil.getCityName;
import static com.logistic.test.cityservice.api.TestDataUtil.getCityRequest;
import static com.logistic.test.cityservice.api.TestDataUtil.getPage;
import static com.logistic.test.cityservice.api.TestDataUtil.getPageResponse;
import static com.logistic.test.cityservice.api.TestDataUtil.getSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.logistic.test.cityservice.api.TestDataUtil;
import com.logistic.test.cityservice.api.dtos.CityRequest;
import java.util.stream.Stream;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.MediaType;

class CityControllerMvcTest extends AbstractMvcTest {

  private final String CITY_ENDPOINT = "/cities";

  @Test
  void shouldSuccessGetAllCities() throws Exception {
    //GIVEN
    when(cityService.getCities(getPage(), getSize(), null)).thenReturn(getPageResponse());

    //WHEN
    mockMvc.perform(get(CITY_ENDPOINT))
        .andExpect(status().isOk());
  }

  @Test
  void shouldSuccessGetCitiesByName() throws Exception {
    //GIVEN
    when(cityService.getCities(getPage(), getSize(), getCityName())).thenReturn(getPageResponse());

    //WHEN
    mockMvc.perform(get(CITY_ENDPOINT)
            .queryParam("cityName", getCityName()))
        .andExpect(status().isOk());
  }

  @Test
  void shouldSuccessUpdateCityByName() throws Exception {
    //GIVEN
    doNothing().when(cityService).updateCity(getCityRequest());

    //WHEN
    mockMvc.perform(put(CITY_ENDPOINT)
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(getCityRequest())))
        .andExpect(status().isOk());
  }

  @Test
  void shouldFailUpdateWhenCityNotFound() throws Exception {
    //GIVEN
    doThrow(EntityNotFoundException.class).when(cityService).updateCity(getCityRequest());

    //WHEN
    mockMvc.perform(put(CITY_ENDPOINT)
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(getCityRequest())))
        .andExpect(status().isNotFound());
  }

  @ParameterizedTest
  @MethodSource("testValidateParams")
  void shouldFailUpdateCityWithInvalidRequest(CityRequest cityRequest, String expectedMessage)
      throws Exception {
    //GIVEN

    //WHEN
    mockMvc.perform(put(CITY_ENDPOINT)
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(cityRequest)))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message", is(expectedMessage)));
  }

  private static Stream<Arguments> testValidateParams() {
    return Stream.of(
        Arguments.of(TestDataUtil.getCityRequestWithNullName(),
            "Id can not be null"),
        Arguments.of(TestDataUtil.getCityRequestWithNullNewName(),
            "City name can not be null or empty"),
        Arguments.of(TestDataUtil.getCityRequestWithEmptyNewName(),
            "City name can not be null or empty"),
        Arguments.of(TestDataUtil.getCityRequestWithInvalidUrl(),
            "Invalid photo URL provided")
    );
  }
}
