FROM openjdk:21

COPY target/ssa-api-customer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8089

ENTRYPOINT ["java", "-jar", "/app.jar"]