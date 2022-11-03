# syntax=docker/dockerfile:1

FROM openjdk:8-jdk-alpine
MAINTAINER com.mediscreen
COPY target/Patients-0.0.1-SNAPSHOT patient-api-0.0.1.jar
ENTRYPOINT ["java","-jar","/patient-api-0.0.1.jar"]