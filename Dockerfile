# Stage 1: Build the application
FROM maven:3.9.12-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY allobank/pom.xml .
COPY allobank/src ./src
RUN mvn test
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:21-rc-slim-bookworm
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
