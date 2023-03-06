City-service-api

Links
local {host}:{port}/cities
swagger /swagger-ui/index.html

Getting started
Prerequisites
Java (JDK 17+)
Maven
Docker

Setting up

1) Clone city-service-api

* Install dependencies
  mvn install
* Run docker-compose file
  docker-compose up

2) Local DB connection

* Set profile - local * url: dbc:postgresql://localhost:5432/city_service
  user: postgres
  password: postgres
