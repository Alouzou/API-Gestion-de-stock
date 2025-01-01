FROM openjdk:17-jdk-slim
LABEL authors="amine"
WORKDIR /app
COPY target/gestiondestock-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
