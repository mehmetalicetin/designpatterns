FROM openjdk:21

COPY target/ssa-api-inventory-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "/app.jar"]