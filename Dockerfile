FROM openjdk:17
WORKDIR /app
COPY target/my-app.jar /app/my-app.jar
CMD ["java", "-jar", "my-app.jar"]