# Use an official OpenJDK image as the base
FROM maven:3.8.4-openjdk-17


# Set the working directory
WORKDIR /app

COPY target/*.jar app.jar

# Expose the port your Spring Boot application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]