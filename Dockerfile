
FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY target/hello-world.jar .
CMD ["java", "-jar", "hello-world.jar"]
