# Circuit Breaker and Fault Tolerance System

## Overview
This project demonstrates Circuit Breaker and Fault Tolerance patterns using Spring Boot and Resilience4j. It simulates a banking platform that integrates with external Credit Check, Customer Verification, and Payment services.

## Technologies Used
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Resilience4j
- MySQL
- Spring Boot Actuator
- Swagger/OpenAPI
- JUnit 5
- Mockito
- Maven

## Features
- Circuit Breaker Implementation
- Retry Mechanism
- TimeLimiter Support
- Fallback Handling
- Customer Verification Module
- Credit Check Module
- Payment Processing Module
- Failure Statistics Tracking
- Audit Logging
- Circuit Breaker Status Monitoring
- Manual Circuit Breaker Reset
- Health Monitoring Endpoints
- Metrics Collection

## Modules

### Credit Check Module
Checks customer credit score through an external service.

### Customer Verification Module
Verifies customer identity and KYC details.

### Payment Processing Module
Processes customer payments through an external gateway.

### Monitoring Module
Provides health checks, metrics, and circuit breaker monitoring.

## API Endpoints

### Credit Check
GET /credit/score

### Customer Verification
GET /customer/verify/{id}

### Payment Processing
GET /payment/process

### Circuit Breaker Status
GET /circuit/status/{name}

### Circuit Breaker Reset
POST /circuit/reset/{name}

### Failure Statistics
GET /failures

## Circuit Breaker States
- CLOSED
- OPEN
- HALF_OPEN

## Monitoring Endpoints

### Health
GET /actuator/health

### Metrics
GET /actuator/metrics

### Circuit Breakers
GET /actuator/circuitbreakers

### Circuit Breaker Events
GET /actuator/circuitbreakerevents

## Database
Stores failure audit logs for external service failures.

### Failure Audit Fields
- Id
- Service Name
- Error Message
- Failure Time

## Testing
Unit testing implemented using:
- JUnit 5
- Mockito

## Project Flow

Customer Request
→ Service Layer
→ External API
→ Circuit Breaker
→ Retry
→ TimeLimiter
→ Fallback Response


## How to Run

1. Configure MySQL database.
2. Update application.properties.
3. Run Maven Build.
4. Start Spring Boot Application.
5. Test APIs using Postman or Swagger.

## Author
Mahesh Kapilabvai