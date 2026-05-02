# Estágio 1 — build
FROM maven:3.9-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Estágio 2 — execução
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/chatbot-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]