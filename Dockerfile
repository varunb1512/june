
FROM openjdk
WORKDIR /app
COPY target/jb-hello-world-maven-0.2.0.jar .
CMD ["java", "-jar", "jb-hello-world-maven-0.2.0.jar"]
