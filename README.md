# Spring REST API Starter 🚀

## Table of Contents

- [What is this repository](#what-is-this-repository)
- [Dependencies](#dependencies)
- [Features](#features)
- [How to use](#how-to-use-this-repository)

## What is this repository

This repository is a remake of a old project that i made using spring and java now applying new things that i learned.

## Dependencies

<details>
<summary>Click to expand!</summary>

| **Dependency**      | **Version** | **Description**                                         |
|---------------------|:-----------:|---------------------------------------------------------|
| Spring Boot         |    2.6.5    | Config Spring-app with Java Annotation                  |
| Spring Security     |    5.6.2    | Securing application                                    |
| Spring Data JPA     |    2.6.5    | Connect database and manipulate data                    |
| MySQL               |     8.x     | Database for application                                |
| Lombok              |   1.18.22   | Generate common method to reduce boilerplate code       |
| Java Validation API |      x      | Validate parameter                                      |
| JJWT                |    3.19.1   | Creating and verifying JSON Web Token in Java           |
| Apache Commons      |    3.12.0   | Contains several useful methods                         |
| H2 database         |   2.1.210   | In memory database                                      |

</details>

## Features

* Language level and runtime JDK is Java 8
* Spring EcoSystem 2.6.5
* Persistence:

    * H2 database


* REST API with Spring Web MVC

    * An `CustomerController` containing all the endpoints related to the customer crud
    * An `EmployeeController` containing all the endpoints related to the employee crud
    * An `ServiceOrderController` containing all the endpoints related to the service order crud
    * An `BudgetController` containing all the endpoints related to the budget crud
    * An `ServiceTypeController` containing all the endpoints related to the services type crud

* Security

    * Authentication with JSON Web Token
    * CORS configuration
    * Annotations to restrict endpoints to certain roles

* Exception Handling

    * Automatic exception handling with `ExceptionControllerAdvice` class

* Utility classes to support common task

    * `TokenUtils` to support common methods to work with the jwt token

## How to use this repository

### Prerequisites

* Globally install Java 8
* Globally install Maven

### Installation

1. Clone this repository.
2. Run the command "mvn install" on this repository's folder.
3. Run the command "mvn spring-boot:run" on this repository's folder in order to run the application.

### How to use
#### Login (the token can be found on the response header)
curl --request POST \
  --url 'http://localhost:8080/login?username=admin%40fixingSolutions.com&password=fixingSolutions'

#### Employee crud
#### Find all 
curl --request GET \
  --url http://localhost:8080/employee/findAll \
  --header 'Authorization: Bearer {your token}
