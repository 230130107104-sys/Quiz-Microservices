FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/api-gateway.jar app.jar

EXPOSE 8765

ENTRYPOINT ["java","-jar","app.jar"]