# syntax=docker/dockerfile:1

FROM openjdk:8-jdk-alpine
MAINTAINER com.mediscreen
COPY target/patient-api-1.0.jar patient-api-1.0.jar
ENTRYPOINT ["java","-jar","/patient-api-1.0.jar"]