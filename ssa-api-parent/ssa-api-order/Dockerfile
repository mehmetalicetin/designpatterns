FROM openjdk:21

COPY target/ssa-api-order-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8092

ENTRYPOINT ["java", "-jar", "/app.jar"]