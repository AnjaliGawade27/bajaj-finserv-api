# Use Java 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Package the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Run the generated JAR
CMD ["java", "-jar", "target/bajajfinservapi-0.0.1-SNAPSHOT.jar"]