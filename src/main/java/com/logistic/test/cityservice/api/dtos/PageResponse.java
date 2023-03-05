package com.logistic.test.cityservice.api.dtos;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PageResponse<T> {

  Long total;
  Integer pages;
  Integer size;
  List<T> content;
}
