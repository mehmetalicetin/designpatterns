FROM openjdk:21

COPY target/gateway-server-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8222

ENTRYPOINT ["java", "-jar", "/app.jar"]