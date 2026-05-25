FROM eclipse-temurin:17-jdk-jammy
COPY . .
RUN apt-get update && apt-get install -y maven && mvn clean package -DskipTests
CMD ["java", "-jar", "target/simqueue-0.0.1-SNAPSHOT.jar"]