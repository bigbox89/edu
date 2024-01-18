FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} students.jar
ENTRYPOINT ["java","-jar","/students.jar"]