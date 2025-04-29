FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/jb-hello-world-maven-0.2.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
