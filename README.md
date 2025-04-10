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

## Monitoring with Prometheus

### Prerequisites for Monitoring
- Docker
- Docker Compose (optional)
- Spring Boot Actuator configured in your application

### Setting up Prometheus

1. Create a Prometheus configuration file:
```yaml
# prometheus.yml
global:
  scrape_interval: 15s  # how often to scrape metrics

scrape_configs:
  - job_name: 'prometheus'
    static_configs:
      - targets: ['localhost:9090']

  - job_name: 'spring-ai'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['host.docker.internal:8080']
```

2. From root of project, Run Prometheus using Docker:
```bash
docker run --rm --name prometheus \
  -p 9090:9090 \
  -v "$PWD/prometheus.yml:/etc/prometheus/prometheus.yml" \
  prom/prometheus

```


Or using Docker Compose:
```yaml
# docker-compose.yml
version: '3.8'
services:
  prometheus:
    image: prom/prometheus
    ports:
      - "9090:9090"
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml
```

Run with:
```bash
docker-compose up -d
```

### Accessing Prometheus

- Prometheus UI: `http://localhost:9090`
- Available metrics: `http://localhost:9090/metrics`
- Targets status: `http://localhost:9090/targets`
- Access Graphs: 'http://localhost:9090/graph'

### Common Metrics

- `ai.request.duration`: Response time for AI requests
- `ai.request.count`: Number of AI requests made
- Status can be monitored via labels: `success` or `failure`

### Docker Commands for Prometheus Management

```bash
# Stop Prometheus
docker stop prometheus

# Start Prometheus
docker start prometheus

# View Prometheus logs
docker logs prometheus

# Remove Prometheus container
docker rm prometheus

# Pull latest Prometheus image
docker pull prom/prometheus


## Monitoring with Grafana

### Prerequisites for Grafana
- Docker
- Docker Compose (optional)
- Prometheus already configured
- Spring Boot Actuator configured

### Setting up Grafana

1. Run Grafana using Docker:
```bash
docker run -d \
    --name grafana \
    -p 3000:3000 \
    grafana/grafana
```

Or using Docker Compose:
```yaml
# docker-compose.yml
version: '3.8'
services:
  prometheus:
    image: prom/prometheus
    ports:
      - "9090:9090"
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml

  grafana:
    image: grafana/grafana
    ports:
      - "3000:3000"
    environment:
      - GF_SECURITY_ADMIN_USER=admin
      - GF_SECURITY_ADMIN_PASSWORD=admin
    volumes:
      - grafana-storage:/var/lib/grafana

volumes:
  grafana-storage:
```

Run with:
```bash
docker-compose up -d
```

### Configuring Grafana

1. Access Grafana UI at `http://localhost:3000`
2. Login with default credentials:
    - Username: `admin`
    - Password: `admin`

3. Add Prometheus Data Source:
    - Click 'Configuration' → 'Data Sources'
    - Add new data source
    - Select 'Prometheus'
    - Set URL: to http://host.docker.internal:9090
    - Click 'Save & Test'

### Sample Dashboards

1. Create a new dashboard for AI metrics:
    - Add panel for Request Duration
      ```
      rate(ai_request_duration_seconds_sum[5m]) / rate(ai_request_duration_seconds_count[5m])
      ```
    - Add panel for Request Count
      ```
      sum(rate(ai_request_count_total[5m])) by (status)
      ```

2. Import existing dashboards:
    - Spring Boot Statistics (ID: 12900)
    - JVM Micrometer (ID: 4701)

### Docker Commands for Grafana Management

```bash
# Stop Grafana
docker stop grafana

# Start Grafana
docker start grafana

# View Grafana logs
docker logs grafana

# Remove Grafana container
docker rm grafana

# Pull latest Grafana image
docker pull grafana/grafana
```

### Backup and Restore

1. Backup Grafana data:
```bash
docker cp grafana:/var/lib/grafana ./grafana-backup
```

2. Restore Grafana data:
```bash
docker cp ./grafana-backup/. grafana:/var/lib/grafana
```

### Useful Environment Variables

```yaml
environment:
  - GF_SECURITY_ADMIN_USER=your_admin_user
  - GF_SECURITY_ADMIN_PASSWORD=your_admin_password
  - GF_USERS_ALLOW_SIGN_UP=false
  - GF_SERVER_DOMAIN=your_domain
  - GF_SMTP_ENABLED=true
  - GF_SMTP_HOST=smtp.example.com
```

### Common Issues and Solutions

1. Can't connect to Prometheus:
    - Check if Prometheus is running: `docker ps`
    - Verify network connectivity between containers
    - Check Prometheus URL in Grafana datasource settings

2. Dashboard not showing data:
    - Verify metrics are being collected in Prometheus
    - Check time range selection in Grafana
    - Validate PromQL queries in Prometheus first

3. Authentication issues:
    - Reset admin password:
   ```bash
   docker exec -it grafana grafana-cli admin reset-admin-password newpassword
   ```
   

## Author

- Chikere Milton Ezeh
