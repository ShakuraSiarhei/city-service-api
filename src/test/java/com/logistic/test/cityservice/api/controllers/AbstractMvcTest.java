package com.logistic.test.cityservice.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistic.test.cityservice.api.services.CityService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {CityController.class})
@ExtendWith(SpringExtension.class)
abstract class AbstractMvcTest {

  @Autowired
  protected MockMvc mockMvc;
  @Autowired
  protected ObjectMapper mapper;
  @MockBean
  protected CityService cityService;
}
