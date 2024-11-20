FROM openjdk:17-jdk-slim
WORKDIR /app

# 환경변수 정의 - api-gateway에 필요한 것만

COPY build/libs/batch-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]