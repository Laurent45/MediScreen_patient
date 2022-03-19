
FROM amazoncorretto:11.0.14
ARG JAR_FILE=MediScreen-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]