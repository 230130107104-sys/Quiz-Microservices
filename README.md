# 🚀 Quiz Application - Spring Boot Microservices

A production-style **Quiz Application** built using **Spring Boot Microservices** following industry-standard backend development practices.

The application allows users to manage questions, create quizzes, attempt quizzes, and calculate scores through independent microservices communicating via REST APIs.

---

# 📖 Overview

This project follows a **Microservices Architecture** where each service has a single responsibility.

It demonstrates:

* Spring Boot 4
* Spring Cloud
* REST APIs
* Service Discovery
* API Gateway
* JWT Authentication
* Spring Security
* Docker
* PostgreSQL
* OpenFeign
* Swagger/OpenAPI
* Global Exception Handling
* Transaction Management
* Service Interface Pattern

---

# 🏗️ Architecture

```text
                            Client
                               │
                               ▼
                    ┌────────────────────┐
                    │     API Gateway    │
                    │ Spring Cloud Gateway│
                    └─────────┬──────────┘
                              │
              ┌───────────────┴───────────────┐
              │                               │
              ▼                               ▼
     ┌──────────────────┐          ┌──────────────────┐
     │ Question Service │          │   Quiz Service   │
     └─────────┬────────┘          └─────────┬────────┘
               │                             │
               └──────────────┬──────────────┘
                              ▼
                     PostgreSQL Database

                              ▲
                              │
                  Eureka Discovery Server
```

---

# ✨ Features

## Question Service

* Add Questions
* Fetch All Questions
* Search Questions by Category
* Generate Random Questions
* Calculate Quiz Score
* Swagger Documentation
* Global Exception Handling
* Service Interface Layer
* Transaction Management

---

## Quiz Service

* Create Quiz
* Fetch Quiz Questions
* Calculate Quiz Result
* OpenFeign Communication
* Swagger Documentation
* Unit Testing
* Service Interface Layer
* Transaction Management

---

## API Gateway

* Spring Cloud Gateway
* JWT Authentication
* Spring Security
* OAuth2 Resource Server
* Route Management

---

## Eureka Server

* Service Registration
* Service Discovery

---

## Docker

* Dockerfile for every microservice
* Docker Compose
* PostgreSQL Container
* Container Networking

---

# 🛠️ Technology Stack

| Technology             | Version  |
| ---------------------- | -------- |
| Java                   | 21       |
| Spring Boot            | 4.0.6    |
| Spring Cloud           | 2025.1.1 |
| Spring Security        | ✓        |
| OAuth2 Resource Server | ✓        |
| JWT (JJWT)             | 0.12.6   |
| Spring Data JPA        | ✓        |
| PostgreSQL             | 15       |
| Spring Cloud Gateway   | ✓        |
| Eureka Discovery       | ✓        |
| OpenFeign              | ✓        |
| Swagger / OpenAPI      | ✓        |
| Docker                 | ✓        |
| Docker Compose         | ✓        |
| Maven                  | ✓        |
| JUnit 5                | ✓        |
| Mockito                | ✓        |

---

# 📂 Project Structure

```text
Quiz-Microservices
│
├── api-gateway
│
├── question-service
│
├── quiz-service
│
├── service-registryy
│
├── docker-compose.yml
│
└── README.md
```

---

# 🔒 Security

Authentication is implemented using:

* Spring Security
* JWT Authentication
* OAuth2 Resource Server

Only authenticated users can access protected APIs.

---

# 📦 Running the Project

## Clone Repository

```bash
git clone https://github.com/<YOUR_GITHUB_USERNAME>/Quiz-Microservices.git
```

```bash
cd Quiz-Microservices
```

---

## Build Every Service

### Question Service

```bash
cd question-service
./mvnw clean package -DskipTests
```

### Quiz Service

```bash
cd ../quiz-service
./mvnw clean package -DskipTests
```

### API Gateway

```bash
cd ../api-gateway
./mvnw clean package -DskipTests
```

### Eureka Server

```bash
cd ../service-registryy
./mvnw clean package -DskipTests
```

---

## Start Everything

```bash
docker compose up --build
```

---

# 📚 API Documentation

After starting the services:

Question Service

```
http://localhost:8081/swagger-ui.html
```

Quiz Service

```
http://localhost:8082/swagger-ui.html
```

---

# 🌟 My Enhancements

Compared to the original implementation, I added the following improvements:

* JWT Authentication
* Spring Security
* OAuth2 Resource Server
* Swagger/OpenAPI Integration
* Global Exception Handling
* Custom Exceptions
* Service Interface + Implementation Pattern
* Transaction Management using `@Transactional`
* Docker Support for every Microservice
* Docker Compose
* PostgreSQL Containerization
* Improved Project Structure
* Unit Testing with Mockito
* Better Error Handling

---

# 🚀 Future Improvements

* Redis Caching
* Kafka/RabbitMQ Messaging
* Spring Cloud Config Server
* Zipkin Distributed Tracing
* Prometheus Monitoring
* Grafana Dashboard
* Kubernetes Deployment
* CI/CD using GitHub Actions
* React Frontend Deployment

---

# 👩‍💻 Author

**Arpita Pathar**

Backend Developer | Java | Spring Boot | Microservices

GitHub: https://github.com/

LinkedIn: https://linkedin.com/in/

---

# 📄 License

This project was developed for learning and demonstrating modern Java backend development using Spring Boot Microservices.
