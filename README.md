# Vacation Booking Back-End System

## Overview
This project involved building a back-end system for a vacation booking application using Spring Boot, following best practices for web development. The goal was to create a fully functional back-end that connects to a front-end interface and integrates with the MySQL database. The project emphasized modular development using Java and Spring frameworks.

## Functionality:
* **User Accounts** traveleres are able to enter their name, tracking #, and address to pull up information.
* **MVC and MySQL** used to offer travelers destination options and excursions as additional add-ons.
* **Tracking Number** and date of reciept offered to travelers once they select the vacation destination and optional leisure activities to select at an additional cost.
* **Vacation and Excursion Images** to show travelers images of where they choose to travel to.

## Project Structure:
### **Package Creation**
* Organized the project structure by creating packages for controllers, entities, DAOs, services, and configuration files.
* Imported configuration files and set up application properties.

### **Entity Classes**
* Developed entity classes using UML diagrams and database schema.
* Mapped database tables to entity fields using @Entity, @Table, and @Column annotations.
* Established relationships such as OneToMany, ManyToOne, and ManyToMany between entities.
* Implemented enumerations for status fields and ensured accurate data mapping.
  
### **Data Access Object (DAO) Implementation**
* Created DAO interfaces for database operations.
* Tested the back-end integration with the front-end by running the MySQL script and verifying data mapping.
  
## **Service Layer Development**
* Built services to handle business logic, including a checkout process for carts.
* Populated cart and customer entities with data and implemented order tracking functionality.
* Verified proper data flow between front-end and back-end.

## **Field Validation**
* Added nullable = false to required fields in entity classes to enforce input validation.

## **Controller Layer**
* Developed REST controllers to handle HTTP requests and responses, ensuring data transfer between front-end and back-end.

## **Data Population**
* Used a Bootstrap class to populate the database with five sample customers.
* Verified customer data by querying the MySQL database and testing the front-end interface.

## Technologies and Tools Used:
* **Spring Boot:** Framework for building Java-based web applications.
* **MySQL:** Database management system for storing and managing data.
* **IntelliJ IDEA:** Integrated development environment (IDE) for Java development.
* **GitLab:** Version control for managing code changes.

## Project Outcomes:
This project demonstrated the integration of a Spring Boot back-end with a MySQL database and a front-end interface. It emphasized:
* **Modular development** using the **MVC** (Model-View-Controller) pattern.
* **Entity relationship mapping** and validation.
* **RESTful API** development and data handling.
