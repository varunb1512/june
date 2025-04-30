FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/java-hello-web-0.1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
