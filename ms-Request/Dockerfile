FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ms-Request.jar
ENTRYPOINT ["java","-jar","/ms-Request.jar"]