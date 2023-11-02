FROM amazoncorretto:17-alpine-jdk
COPY target/JavaFxMaven-1.0-SNAPSHOT.jar app.jar
COPY target/libs /libs/
ENTRYPOINT ["java", "-jar", "/app.jar"]
