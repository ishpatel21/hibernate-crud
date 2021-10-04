# README #

Spring boot + Hibernate ORM CRUD

### What is this repository for? ###

* Integrated Postgres Database (Hibernate ORM(5.4.22) supported) with a Spring Boot Application and perform different CRUD operations (Create, Read, Update, and Delete operations) with entities. You can add more entities under hibernate-crud/src/main/java/com/example/hibernatecrud/entities/. No need to change controllers/services.

### How do I start in local? ###

* Before running, make sure to run postgres database in local with Employee table(id:integer, name:text)
* Then run application on port 8080
* To test, go to http://localhost:8080/swagger-ui.html and perform CRUD operations
