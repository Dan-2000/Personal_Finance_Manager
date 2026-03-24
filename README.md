Personal Finance Manager - 

A full-stack personal finance application built with Spring Boot, PostgreSQL and React, allowing users to track income and expenses through a REST API with a clean, responsive frontend.
Live Demo: personalfinancemanagerfrontend-production.up.railway.app

---------------------------------------------------------
Tech Stack
Backend

Java 25 / Spring Boot 4
Spring Data JPA / Hibernate
PostgreSQL
Docker (local development)
Maven

---------------------------------------------------------
Frontend

React 18
Tailwind CSS
Deployed on Railway

---------------------------------------------------------
Features

Add income and expense transactions with date, description and amount
View all transactions in descending order, colour coded by type
Live financial summary showing total income, total expenses and net balance
Input validation with custom error messages
Global exception handling with clean JSON error responses
REST API with proper HTTP status codes (200 OK, 201 Created, 400 Bad Request)

---------------------------------------------------------
API Endpoints

MethodEndpointDescriptionGET/Health checkGET/transactionsGet all transactionsPOST/transactionsAdd a new transactionGET/summaryGet income, expenses and net balance
Example POST request

bashcurl -X POST https://personalfinancemanager-production-cbb6.up.railway.app/transactions \

-H "Content-Type: application/json" \

-d '{

  "date": "2026-03-24",
  
  "description": "Coffee",
  
  "amount": 5.50,
  
  "type": "EXPENSE"
}'

---------------------------------------------------------
Example response

json{

  "id": 1,
  
  "date": "2026-03-24",
  
  "description": "Coffee",
  
  "amount": 5.50,
  
  "type": "EXPENSE"
}


---------------------------------------------------------
Running Locally

Prerequisites

Java 17+

Maven

Docker

---------------------------------------------------------
Backend

bash# Start PostgreSQL via Docker

docker run --name finance-db \

  -e POSTGRES_USER=postgres \
  
  -e POSTGRES_PASSWORD=postgres \
  
  -e POSTGRES_DB=finance_db \
  
  -p 5433:5432 \
  
  -d postgres

---------------------------------------------------------
# Run the Spring Boot app

cd backend

./mvnw spring-boot:run

---------------------------------------------------------
Frontend

bashcd frontend

npm install

npm run build

npx serve -s build

---------------------------------------------------------
Validation Rules

FieldRuledateRequired, format YYYY-MM-DDdescriptionRequired, non-emptyamountRequired, must be positivetypeRequired, must be INCOME or EXPENSE

---------------------------------------------------------
Planned Features

User authentication with Spring Security and JWT

Per-user transaction history

Delete and edit transactions
Filter transactions by date or type

