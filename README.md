# blood-bank-api

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `biojj.BloodBankApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Spring Boot Back-end
Visão geral
Estas são APIs que o Spring Boot App exportará:

BASEURL: localhost:8080/


Methods	  | Urls	              | Actions
----------|---------------------|---------
POST	    |  /api/candidate	    |create new candidate
GET	      |  /api/candidate	    |retrieve all candidates
GET	      |  /api/candidate/:id |retrieve a candidate by :id
PUT	      |  /api/candidate/:id |update a candidate by :id
DELETE	  |  /api/candidate/:id |delete a candidate by :id
POST	    |  /api/users    	    |create new user
POST	    |  /oauth/token	      |Login
## Copyright
