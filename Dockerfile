# Backend Spring Boot
FROM eclipse-temurin:21-jdk-alpine

LABEL authors="Paulo Henrique"

WORKDIR /app

# Copia pom.xml e instala dependências
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copia todo o código
COPY src ./src

# Build do backend
RUN ./mvnw package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]