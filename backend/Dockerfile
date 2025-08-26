FROM openjdk:21-jdk-slim
RUN groupadd -r spring && useradd -r -g spring spring

USER spring

ARG JAR_FILE=target/canvas-arc-demo.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
