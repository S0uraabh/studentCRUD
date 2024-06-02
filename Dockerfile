# Use AdoptOpenJDK 11 as base image
FROM adoptopenjdk/openjdk11:alpine-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container at path /app
COPY target/studentCRUD-1.0-SNAPSHOT.jar /app/studentCRUD.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Command to run the jar file
CMD ["java", "-jar", "studentCRUD.jar"]
