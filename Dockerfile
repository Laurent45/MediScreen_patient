
FROM amazoncorretto:11.0.14
ARG JAR_FILE=build/libs/MediScreen-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} patient.jar
ENTRYPOINT ["java", "-jar", "patient.jar"]