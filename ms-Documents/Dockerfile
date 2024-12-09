FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ms-Documents.jar
ENTRYPOINT ["java","-jar","/ms-Documents.jar"]