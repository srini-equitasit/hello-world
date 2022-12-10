FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar spring-boot-hello.jar
ENTRYPOINT ["java","-jar","/spring-boot-hello.jar"]

EXPOSE 8081