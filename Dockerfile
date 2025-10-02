FROM openjdk:17-jdk-slim

# Installer MySQL client et configurer
RUN apt-get update && apt-get install -y mysql-client && rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY target/khaddemMaramArfaoui-1.0.jar app.jar

EXPOSE 8089

# Utiliser un profil Spring sans DB pour le test
CMD ["java", "-jar", "-Dspring.profiles.active=test", "app.jar"]
