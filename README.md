# README #

Spring boot + Hibernate ORM CRUD

### What is this repository for? ###

* Integrate any Hibernate ORM(5.4.22) supported database with a Spring Boot Application and perform different CRUD operations (Create, Read, Update, and Delete operations) with provided entities

### How do I start in local? ###

* Before running, make sure to run postgres database in local with Employee table(id:integer, name:text)
* Then run application on port 8080
* To test, go to http://localhost:8080/swagger-ui.html and perform CRUD operations

### How can I convert this project for my project? ###

* Go to https://docs.jboss.org/hibernate/stable/orm/userguide/html_single/Hibernate_User_Guide.html#database-dialect and find dialect for your database
* If your database is supported there, add dependency for your database in pom.xml. 
* Add database connection properties in application.properties
* Add Hibernate entities in src/main/java/entities
* Then run the application