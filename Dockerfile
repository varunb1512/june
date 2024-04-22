
FROM openjdk
WORKDIR /app
COPY /home/runner/work/Hello_World/Hello_World/target/jb-hello-world-maven-0.2.0-shaded.jar .
CMD ["java", "-jar", "jb-hello-world-maven-0.2.0-shaded.jar"]
