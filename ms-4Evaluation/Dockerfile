FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ms-Evaluation.jar
ENTRYPOINT ["java","-jar","/ms-Evaluation.jar"]