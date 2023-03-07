package com.logistic.test.cityservice.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

  @NotNull(message = "Id can not be null")
  Long id;
  @NotEmpty(message = "City name can not be null or empty")
  String newName;
  @Pattern(regexp = "^(https://|http://).*$", message = "Invalid photo URL provided")
  String newPhoto;
}
