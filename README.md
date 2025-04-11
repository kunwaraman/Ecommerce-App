# Product Catalog API

This is a Spring Boot REST API for managing product categories and products in an e-commerce system.

## Features

- CRUD operations for **Categories** and **Products**
- Retrieve all categories
- Retrieve all products
- Retrieve products by category

## Technologies Used

- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Hibernate**
- **Lombok**

## Setup Instructions

### 1. Clone the Repository

```sh
 git clone https://github.com/yourusername/product-catalog.git
 cd product-catalog
```

### 2. Configure Database

Update the `application.properties` file in `src/main/resources/`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecomdb
spring.datasource.username=root
spring.datasource.password=aman123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### 3. Build and Run the Application

```sh
 mvn clean install
 mvn spring-boot:run
```

## API Endpoints

### Category Endpoints

| Method | Endpoint          | Description        |
| ------ | ----------------- | ------------------ |
| GET    | `/api/categories` | Get all categories |

### Product Endpoints

| Method | Endpoint                              | Description              |
| ------ | ------------------------------------- | ------------------------ |
| GET    | `/api/products`                       | Get all products         |
| GET    | `/api/products/category/{categoryId}` | Get products by category |

## Models

### Category Model

```java
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;
}
```

### Product Model

```java
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
```

Some question also
Spring Boot & REST API
What is the purpose of the @RestController annotation in Spring Boot?

How does @RequestMapping work in a Spring Boot controller?

What is the difference between @GetMapping, @PostMapping, @PutMapping, and @DeleteMapping?

How would you handle exceptions in a Spring Boot REST API?

What are the benefits of using Spring Boot for building microservices?

How can you enable Cross-Origin Resource Sharing (CORS) in your Spring Boot application?

Spring Data JPA & Hibernate
What is the role of @Entity and @Table annotations in JPA?

How does Hibernate handle relationships between entities, such as @OneToMany and @ManyToOne?

What is the purpose of cascade = CascadeType.ALL in a JPA entity?

What is the difference between FetchType.LAZY and FetchType.EAGER in Hibernate?

What happens when you set spring.jpa.hibernate.ddl-auto=update in the application.properties file?

How do you write custom queries using Spring Data JPA?

Database & Transactions
What is the significance of @Transactional in Spring Boot?

How would you optimize database queries in a Spring Boot application?

How do you implement pagination and sorting in Spring Data JPA?

Security & Performance
How would you secure your REST API endpoints?

What are the best practices for handling sensitive data like database passwords in Spring Boot?

How can you improve the performance of a Spring Boot application?

How would you handle authentication and authorization in an e-commerce application?

Deployment & Scaling
What are the steps to deploy a Spring Boot application on AWS?

How do you configure logging in a Spring Boot application?

What is the purpose of an application.properties or application.yml file?

How can you enable caching in a Spring Boot application?


