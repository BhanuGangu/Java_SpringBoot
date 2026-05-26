# Java_SpringBoot

# Student Management System

This is a Java Spring Boot project for managing student information. The project uses Spring Boot, Spring MVC, Spring Data JPA, MySQL, Thymeleaf, and HTML to perform basic CRUD operations.

## Project Overview

The Student Management System allows users to create, read, update, and delete student records. The application follows a layered architecture to keep the code clean, organized, and easy to maintain.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL
- Thymeleaf
- HTML
- Bootstrap
- Maven
- Eclipse IDE

## Features

- Add new students
- View all students
- Update student details
- Delete student records
- Store student data in MySQL database
- Layered project structure using Controller, Service, and Repository layers

## Project Architecture

This project is divided into three main layers:

### 1. Controller Layer

The Controller layer handles requests coming from the client/browser.

It contains the CRUD endpoints and is responsible for mapping user requests to the correct service methods.

Example responsibilities:

- Display all students
- Show create student form
- Save student details
- Edit student details
- Delete student records

### 2. Service Layer

The Service layer contains the business logic of the application.

It is responsible for:

- Handling validation logic
- Communicating between Controller and Repository layers
- Converting Entity objects to DTO objects
- Converting DTO objects back to Entity objects
- Managing business operations related to students

### 3. Repository Layer

The Repository layer is responsible for database operations.

It uses Spring Data JPA to:

- Fetch student records from the database
- Save new student records
- Update existing student records
- Delete student records

## Base URL

```text
http://localhost:8080/api/students

This are the properties you need to take care
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}


