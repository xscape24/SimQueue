# SimQueue

### Full-Stack Queue Simulation & Optimization Platform

SimQueue is a full-stack software system built with Java and Spring Boot for modeling, simulating, and optimizing queueing systems through discrete-event simulation techniques.
<img width="1892" height="861" alt="image" src="https://github.com/user-attachments/assets/a5c84734-75df-4676-b735-336d47bfe16b" />
<img width="1717" height="525" alt="image" src="https://github.com/user-attachments/assets/056dd6f5-02e4-41e8-be4c-09341bda988a" />


---

## Features

- Discrete-event queue simulation engine
- Queue throughput and bottleneck analysis
- Modular queueing strategy architecture
- Spring Boot backend with REST-style architecture
- HTML/CSS/JavaScript frontend served directly through Spring Boot
- Maven dependency and build management
- Multi-stage Docker containerization workflow
- Docker Compose deployment support
- Responsive frontend interface
- Lightweight production-ready runtime containers

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Framework
- Maven

### Frontend
- HTML5
- CSS3
- JavaScript

### DevOps & Deployment
- Docker
- Docker Compose

---

## Architecture

SimQueue uses a full-stack Spring Boot architecture where frontend assets are served directly through the backend.

Frontend files are located inside:

```bash
src/main/resources/static
```

Spring Boot automatically serves the frontend at runtime, meaning no separate frontend server or framework setup is required.

The project also uses a multi-stage Docker build process:

### Build Stage
Compiles the Maven project and packages the executable JAR.

```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
```

### Runtime Stage
Copies only the compiled artifact into a lightweight runtime container.

```dockerfile
FROM eclipse-temurin:17-jre
```

Benefits include:

- Smaller image sizes
- Faster startup performance
- Cleaner deployment artifacts
- Reduced attack surface

---

## Prerequisites

Make sure you have the following installed:

- Java JDK 17+
- Apache Maven 3.8+
- Docker
- Docker Compose
- Git

Verify installations:

```bash
java -version
mvn -version
docker --version
docker-compose --version
git --version
```

---

## Installation

Clone the repository:

```bash
git clone https://github.com/xscape24/SimQueue.git

cd SimQueue
```

Install dependencies and build the project:

```bash
mvn clean install
```

---

## How to Run

HTML/CSS/JS files live inside:

```bash
src/main/resources/static
```

Spring Boot serves everything automatically.

No separate frontend setup is needed.

Start the backend from the project root:

```bash
mvn spring-boot:run
```

Then open:

```bash
http://localhost:8080
```

The frontend loads automatically through Spring Boot.

Keep the terminal open while using the application. Closing it stops the backend server.

---

## Running from IntelliJ

1. Open the project in IntelliJ
2. Find the main class annotated with:

```java
@SpringBootApplication
```

3. Click the green Run button

---

## Important Notes

Do NOT open `index.html` directly by double-clicking it.

That runs the application on the `file://` protocol, which can break:

- API calls
- Images
- Fonts
- JavaScript modules
- Routing behavior

Always access the application through:

```bash
http://localhost:8080
```

---

## SimulationRunner.java Note

If the simulation automatically starts before opening the browser, check that:

```java
SimulationRunner.java
```

does NOT implement:

```java
CommandLineRunner
```

The simulation should only start when triggered through the frontend, not automatically during application startup.

---

## Port Already in Use

If port `8080` is already occupied:

```bash
netstat -ano | findstr :8080
```

Copy the PID from the last column, then terminate it:

```bash
taskkill /PID 12345 /F
```

Replace:

```bash
12345
```

with the actual PID.

Then rerun:

```bash
mvn spring-boot:run
```

---

## Running with Docker

Build and start containers:

```bash
docker-compose up --build
```

Stop containers:

```bash
docker-compose down
```

Build Docker image manually:

```bash
docker build -t simqueue .
```

Run container manually:

```bash
docker run -p 8080:8080 simqueue
```

---

## Project Structure

```bash
SimQueue/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │       └── static/
│   │           ├── index.html
│   │           ├── css/
│   │           ├── js/
│   │           └── assets/
│   └── test/
├── target/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## Lessons Learned

- Strengthened understanding of full-stack Spring Boot architecture
- Learned how Spring Boot serves static frontend assets without a separate frontend server
- Improved backend organization using layered application structure
- Gained experience building discrete-event simulation systems
- Learned Docker multi-stage build optimization techniques
- Improved understanding of containerized deployment workflows
- Developed better debugging and runtime troubleshooting practices
- Strengthened understanding of Maven dependency management and build lifecycles

---

## Future Improvements

- Real-time queue analytics dashboard
- Graph-based simulation visualizations
- Persistent database integration
- Authentication and user accounts
- Advanced queue strategy algorithms
- WebSocket-based live simulation updates
- Cloud deployment pipeline

---

## Contributing

Contributions are welcome.

Create a feature branch:

```bash
git checkout -b feature/your-feature-name
```

Commit changes:

```bash
git commit -m "Add new simulation feature"
```

Push branch:

```bash
git push origin feature/your-feature-name
```

Open a Pull Request.

---

## License

MIT License

Copyright (c) 2026 SimQueue
