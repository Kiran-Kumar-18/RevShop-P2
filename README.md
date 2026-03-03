# RevShop E-Commerce Application

RevShop is a comprehensive B2C e-commerce platform built with Spring Boot, providing a robust marketplace for buyers and sellers. It features a modern, responsive frontend and a secure, stateless REST API backend.

##  Key Features

###  Buyer Functionality
- **Product Discovery**: Browse products by categories, search with keywords, and view detailed product information.
- **Shopping Cart**: Add products to cart, update quantities, and manage items before checkout.
- **Order Management**: Place orders with multiple payment methods (including Credit Card, UPI, and COD), view order history, and track status.
- **Wishlist & Reviews**: Save favorite products to a wishlist and provide feedback via product reviews.
- **Security & Profile**: Secure login/registration, password recovery via security questions, and address management.

###  Seller Functionality
- **Product Management**: Add, update, and delete products, including image uploads and stock tracking.
- **Order Tracking**: Monitor customer orders, update shipment statuses, and view sales performance.
- **Dashboard**: Gain insights into business metrics and manage store information.

### ️ Core Technical Features
- **JWT Authentication**: Secure, stateless session management using JSON Web Tokens.
- **Hybrid Storage**: Combines `localStorage` for frontend persistence and `HttpSession` for web-flow stability.
- **Robust Exception Handling**: Centralized global exception handler for consistent API responses.
- **Modern UI**: Responsive design using Thymeleaf templates and Vanilla CSS/JS.
- **Logging**: Comprehensive audit trails using Log4j2.

## ️ Technology Stack

- **Backend**: Java 21, Spring Boot 3.3.5
- **Security**: Spring Security, JWT (jjwt)
- **Data Access**: Spring Data JPA, Hibernate
- **Database**: Oracle DB (Production), H2 (Testing)
- **Frontend**: Thymeleaf, HTML5, Vanilla CSS, JavaScript
- **Logging**: Log4j2
- **Build Tool**: Maven

##  Project Structure

```text
src/main/java/com/rev/app/
├── config/             # Security, JWT, and App configurations
├── controller/         # REST and Web controllers (API/MVC)
├── dto/                # Data Transfer Objects for API requests/responses
├── entity/             # JPA Entities representing database tables
├── exception/          # Global exception handling logic
├── mapper/             # Component for DTO-Entity conversions
├── repository/         # Spring Data JPA repositories
└── service/            # Business logic and service implementations
```

##  API Overview (Sample Endpoints)

| Method | Endpoint | Description | Access |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/auth/login` | Authenticate user and receive JWT | Public |
| `GET` | `/api/products` | Retrieve all products (paginated) | Public |
| `POST` | `/api/products` | Create a new product | Seller |
| `GET` | `/api/cart/{userId}` | Get user's shopping cart | Authenticated |
| `POST` | `/api/orders` | Place a new order | Buyer |

## ️ Setup & Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   ```
2. **Configure Database**: Update `src/main/resources/application.properties` with your Oracle DB credentials.
3. **Build the project**:
   ```bash
   mvn clean install
   ```
4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```
   Access the app at `http://localhost:8081`.

##  Testing
Run tests using Maven:
```bash
mvn test
```
The project uses **JUnit 5** and **Mockito** for unit testing, and **H2** as an in-memory database for repository tests.
