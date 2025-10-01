FROM openjdk:17-jdk-slim
WORKDIR /app
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/app.jar"]
