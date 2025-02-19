#FROM gradle:7-jdk11 AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle shadowJar --no-daemon

FROM openjdk:11
EXPOSE 8080
COPY /build/libs/backend-0.0.1-SNAPSHOT.jar colley-backend.jar
ENTRYPOINT ["java", "-jar", "colley-backend.jar"]