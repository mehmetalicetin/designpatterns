# Self Service Application Project

## Goal

> The goal of the project is to build an application on which the customer will be able to add products to his cart and make product orders.

## Summary

The project will have multiple components. There will be 4 backend Spring APIs: Customer API, Inventory API, Cart API,
and Order API, which will be responsible of database transactions and business logics. There will also be the frontend
application (GUI) built with JSF and PrimeFaces, which will handle customer interactions and make API calls as
necessary. Finally, all components will be configured to report errors to the Sentry platform.

## Guidelines

### Projects/codes structure

- Maven should be used in all components in order to properly handle dependencies
- Codes should not be duplicated, common codes (mainly data models and clients) should be placed in seperate projects
- Modularity and flexibility is important, Spring's features should be used (proper use of interfaces, beans)
- Codes should be commented when required, documenting methods is mandatory
- All components should have unit tests (JUnit), and integration tests (by mocking clients, using Selenium) when
  required
- Errors and important events should be reported to Sentry

### Version control

- Codes should use version control and should be hosted on the same GitLab repository
- Commit messages should be meaningful
- Codes will be send to the master branch of the repository using merge requests, which should have valid titles and
  explanations about what has been done

### APIs

- APIs will be built using Spring Boot and Hibernate (PostgreSQL), each API will have its own database (or schema)
- APIs should make requests between them which will ensure integrity and security
- APIs will be documented using Swagger and appropriate annotations (
  see [Springdoc](https://github.com/springdoc/springdoc-openapi)), clients and models can be automatically generated
  with the Maven Swagger Codegen dependency
- Spring Boot Actuator should be configured

### Deployment

- Docker files should be provided for each component
- A readme file should describe how to start the components

## Requirements

### Customer API

#### Models

- Customer
    - id: UUID
    - name: String
    - address: String
    - createDate: DateTime

#### Endpoints

- GET /customer/{id}
    - returns details of customer with given id
- POST /customer
    - creates customer from name and address
    - returns newly created customer details

### Inventory API

#### Models

- Product
    - id: UUID
    - name: String
    - description: String
    - price: double
    - discount: double
    - stockQuantity: int
    - imageUrl: String

#### Endpoints

- GET /product
    - returns all available products
- GET /product/{id}
    - returns details of product with given id
- POST /product/{id}/use/{quantity}
    - removes given quantity from the stock quantity of the product with given id

### Cart API

#### Models

- Cart
    - id: UUID
    - customerId: UUID
    - createDate: DateTime
    - lastUpdate: DateTime
    - items: List<CartItem> (OneToMany relation)

- CartItem
    - id: UUID
    - productId: UUID
    - quantity: int
    - createDate: DateTime
    - lastUpdate: DateTime

#### Endpoints

- GET /cart/{id}
    - returns details of cart with given id
- POST /cart
    - creates cart
    - returns newly created cart id
- POST /cart/{id}/add/{productId}/{quantity}
    - adds the product with given id with given quantity to the cart with given id
- POST /cart/{id}/remove/{productId}/{quantity}
    - removes the product with given id with given quantity to the cart with given id
- DELETE /cart/{id}
    - deletes the cart with given id

### Order API

#### Models

- Order

    - id: UUID
    - customerId: UUID
    - customerName: String
    - customerAddress: String
    - totalPrice: double
    - totalDiscount: double
    - uniqueProducts: int
    - totalProducts: int
    - createDate: DateTime

- OrderItem

    - id: UUID
    - productId: UUID
    - productName: String
    - quantity: int
    - unitPrice: double
    - unitDiscount: double
    - totalPrice: double
    - totalDiscount: double

#### Endpoints

- GET /order/{id}
    - returns details of order with given id
- GET /order/customer/{customerId}
    - returns all orders of customer with given id
- POST /order/{cartId}
    - creates an order from cart with given id
    - deletes the cart
    - returns newly created order details

### GUI

#### Home page

- Lists products in a grid view, with add and remove buttons for each cell
- Cart button should be present to see the cart page

#### Cart page

- Lists cart items, and shows prices and discounts
- Order button should be present to create the order

#### Order page

- Displays order details after having created an order

## Getting Started

- Clone/fork this repository
- Configure application.properties files: API ports, database connections, ...
- Create repositories, models, controllers
- Generate clients with Swagger
- ...
