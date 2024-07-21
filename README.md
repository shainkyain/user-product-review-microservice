# User-Product-Review Microservice

**Overview**

The User-Product-Review Microservice is a set of microservices designed to manage users, products, and reviews in a scalable and efficient manner. The project is built using Spring Boot and includes the following main components:

User Service: Manages user information.

Product Service: Handles product information and catalog.

Review Service: Manages user reviews for products.

The microservices communicate with each other using Spring WebClient and persist data using Spring Data JPA with MySQL.
Lombok is used to reduce boilerplate code.

**Modules**

1. **User Service**

Technology: Spring Boot, Spring Data JPA, MySQL, Lombok

**Functionality:**

User registration 

User profile management

2. **Product Service**

Technology: Spring Boot, Spring Data JPA, MySQL, Lombok

**Functionality:**

CRUD operations for products

Product catalog management

3. **Review Service**

Technology: Spring Boot, Spring Data JPA, MySQL, Lombok, Spring WebClient

**Functionality:**

CRUD operations for reviews

Linking reviews with users and products

**Prerequisites**

Java 17 or higher

Maven 3.6.0 or higher

MySQL 8.0 or higher

**Setup**

Clone the repository:


git clone https://github.com/shainkyain/user-product-review-microservice.git

cd user-product-review-microservice

**Set up MySQL:**

Create databases for each service:

CREATE DATABASE user;

CREATE DATABASE product;

CREATE DATABASE review;

Update the MySQL configurations in each service's application.properties file.

**Build and Run the Services:**

Navigate to each service directory and run:

mvn clean install

mvn spring-boot:run

**API Endpoints:**

**User Service:**

POST /users - Register a new user

GET /users/{id} - Retrieve user information

GET /users - Retrive all users information

**Product Service:**

POST /products - Add a new product

GET /products/{id} - Retrieve product information

GET /products - Retrive all products information

**Review Service:**

POST /reviews - Add a new review

GET /reviews/{id} - Retrieve review information

GET /reviews - Retrive all review + (product & user ) information

**Dependencies**

Spring Boot: Core framework for building microservices

Spring Data JPA: ORM for database interactions

MySQL: Database for persisting data

Spring WebClient: Non-blocking, reactive client to perform HTTP requests

Lombok: Library for reducing boilerplate code




![Screenshot (50)](https://github.com/user-attachments/assets/b698e2e8-7901-47f9-a01b-10af52fa812f)
![Screenshot (49)](https://github.com/user-attachments/assets/481d4cbc-f3ca-44ae-8d81-db0146d6389b)
![Screenshot (48)](https://github.com/user-attachments/assets/0bb90371-7ff0-47eb-8720-11413750f03b)
![Screenshot (47)](https://github.com/user-attachments/assets/7ef7e03b-9ff0-4310-9d72-69db2b038455)
![Screenshot (46)](https://github.com/user-attachments/assets/d7fac50a-53c4-4397-80f4-df19d23c227c)
![Screenshot (45)](https://github.com/user-attachments/assets/956df2dc-bc61-4a21-b7eb-72936adf58f9)

**Contributors**

Devil

**License**

This project is licensed under the MIT License - see the LICENSE file for details.

**Contact**

If you have any questions or feedback, please contact **jainshainky123@gmail.com**.
