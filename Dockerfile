FROM eclipse-temurin:17-jdk-jammy
COPY . .
RUN ./mvnw clean package -DskipTests
CMD ["java", "-jar", "target/simqueue-0.0.1-SNAPSHOT.jar"]