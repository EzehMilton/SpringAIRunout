# Spring AI Demo

A Java-based project demonstrating the integration of AI capabilities using Spring AI framework.

## Overview

This project showcases the implementation of AI tools and chat functionalities using Spring AI, built with Jakarta EE.

## Technologies Used

- Java 21
- Spring Framework
- Spring AI

## Features

- AI-powered chat endpoint
- Custom AI tools implementation
- RESTful API integration

## Getting Started

### Prerequisites

- JDK 21
- Maven
- Your favorite IDE (IntelliJ IDEA recommended)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/spring-ai-demo.git
```

2. Navigate to the project directory:
```bash
cd spring-ai-demo
```

3. Build the project:
```bash
mvn clean install
```

### Running the Application

Run the application using:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Chat Endpoint
- URL: `/api/openai/chat`
- Method: `GET`
- Query Parameter: `message`
- Example: `http://localhost:8080/api/openai/chat?message=Your message here`

## Configuration

Configure your application properties in `application.properties` or `application.yml` file.


## Author

- Chikere Milton Ezeh
