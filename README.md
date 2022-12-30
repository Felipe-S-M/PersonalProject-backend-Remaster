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
    * An `AuthorityController` containing all the endpoints related to the roles crud
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
#### Create
curl --request POST \
  --url http://localhost:8080/employee/createEmployee \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"username": "test@hotmail.com",
	"password": "TEST",
	"name": "Test",
	"authoritiesIds": [
		"34"
	]
}'
#### Update
curl --request POST \
  --url http://localhost:8080/employee/editEmployee \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"username": "testEdit@hotmail.com",
	"password": "testEdit",
	"name": "testEdit",
	"id": "35",
	"authoritiesIds": [
		"34"
	]
}'
### Delete
curl --request DELETE \
  --url http://localhost:8080/employee/delete/{id} \
  --header 'Authorization: Bearer {your token}'

#### Authority
#### Find all
curl --request GET \
  --url http://localhost:8080/authority/findAll \
  --header 'Authorization: Bearer {your token}'
#### Create
curl --request POST \
  --url http://localhost:8080/authority/create \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"role": "ROLE_TEST"
}'
#### Update
curl --request POST \
  --url http://localhost:8080/authority/edit \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"id":"34",
	"role": "ROLE_TEST1"
}'
#### Delete
curl --request DELETE \
  --url http://localhost:8080/authority/delete/{id} \
  --header 'Authorization: Bearer {your token}'

#### Service Type
#### Find all
curl --request GET \
  --url http://localhost:8080/serviceType/findAll \
  --header 'Authorization: Bearer {your token}'
#### Create
curl --request POST \
  --url http://localhost:8080/serviceType/create \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"description": "Screen swap",
	"value": "325.50"
}'
#### Update
curl --request POST \
  --url http://localhost:8080/serviceType/edit \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"id": "33",
	"description": "Screen swap",
	"value": "355.50"
}'
#### Delete
curl --request DELETE \
  --url http://localhost:8080/serviceType/delete/{id} \
  --header 'Authorization: Bearer {your token}'

#### Budget
#### Find all
curl --request GET \
  --url http://localhost:8080/budget/findAll \
  --header 'Authorization: Bearer {your token}'
#### Create
curl --request POST \
  --url http://localhost:8080/budget/create \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"expectedHours": "1",
	"isApproved": "false",
	"customerId": "1",
	"servicesTypesIds": [
		"33"
	]
}'
#### Update
curl --request POST \
  --url http://localhost:8080/budget/edit \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"id": "65",
	"expectedHours": "3",
	"isApproved": "false",
	"customerId": "1",
	"servicesTypesIds": [
		"33",
	]
}'
#### Delete
curl --request DELETE \
  --url http://localhost:8080/budget/delete/{id} \
  --header 'Authorization: Bearer {your token}'

#### Service Order
#### Find all
curl --request GET \
  --url http://localhost:8080/serviceOrder/findAll \
  --header 'Authorization: Bearer {your token}'
#### Create
curl --request POST \
  --url http://localhost:8080/serviceOrder/create \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"budgetId": "66",
	"name": "test"
}'
#### Update
curl --request POST \
  --url http://localhost:8080/serviceOrder/edit \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"id": "1",
	"budgetId": "66",
	"name": "test",
	"status": "ON_GOING" 
}'
#### Delete
curl --request DELETE \
  --url http://localhost:8080/serviceOrder/delete/{id} \
  --header 'Authorization: Bearer {your token}'

#### Customer
#### Find all
curl --request GET \
  --url http://localhost:8080/customer/findAll \
  --header 'Authorization: Bearer {your token}'
#### Create
curl --request POST \
  --url http://localhost:8080/customer/create \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "test",
	"email": "teste",
	"cpf": "081.251.929-99",
	"phone": "40028922"
}'
#### Update
curl --request POST \
  --url http://localhost:8080/customer/update \
  --header 'Authorization: Bearer {your token}' \
  --header 'Content-Type: application/json' \
  --data '{
	"id": "2",
	"name": "testeEdit",
	"email": "testeEdit",
	"cpf": "081.251.929-98",
	"phone": "40028923"
}'
#### Delete
curl --request DELETE \
  --url http://localhost:8080/customer/delete/{id} \
  --header 'Authorization: Bearer {your token}'
