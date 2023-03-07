package com.logistic.test.cityservice.api.controllers;

import com.logistic.test.cityservice.api.dtos.CityCriteria;
import com.logistic.test.cityservice.api.dtos.CityRequest;
import com.logistic.test.cityservice.api.dtos.CityResponse;
import com.logistic.test.cityservice.api.dtos.ExceptionResponse;
import com.logistic.test.cityservice.api.dtos.PageResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Pageable;

public interface CityController {

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Get all cities with pagination",
          content = @Content(mediaType = "application/json",
              array = @ArraySchema(schema = @Schema(implementation = CityResponse.class))))
  })
  PageResponse<CityResponse> getAllCities(Pageable pageable);

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Search by city name with pagination",
          content = @Content(mediaType = "application/json",
              array = @ArraySchema(schema = @Schema(implementation = CityResponse.class))))
  })
  PageResponse<CityResponse> searchCityByName(Pageable pageable, CityCriteria criteria);


  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Update city by name",
          content = @Content(mediaType = "application/json",
              array = @ArraySchema(schema = @Schema(implementation = CityResponse.class)))),
      @ApiResponse(responseCode = "400", description = "Id can not be null | City name can not be empty",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
      @ApiResponse(responseCode = "404", description = "City named % not found",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
  })
  void updateCity(CityRequest cityRequest);
}