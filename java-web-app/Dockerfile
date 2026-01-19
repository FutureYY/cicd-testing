# =========================
# Build stage
# =========================
FROM eclipse-temurin:17-alpine as build
WORKDIR /workspace/app

# Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Build the fat jar (skip tests)
RUN ./mvnw package -DskipTests

# =========================
# Runtime stage
# =========================
FROM eclipse-temurin:17-alpine
VOLUME /tmp

# Set a default PORT so Spring Boot can bind
ENV PORT=8080

# Copy the fat jar from the build stage
COPY --from=build /workspace/app/target/*.jar app.jar

# Start the application
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "/app.jar"]
