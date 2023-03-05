package com.logistic.test.cityservice.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityRequest {
  @NotNull(message = "You can not update a city with a null name")
  String currentName;
  @NotEmpty(message = "City name can not be empty")
  String newName;
  String photo;
}
