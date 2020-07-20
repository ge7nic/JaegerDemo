FROM adoptopenjdk/openjdk11:alpine-slim
VOLUME /tmp
COPY target/*.jar jaeger-demo.jar
ENTRYPOINT ["java", "-jar", "/jaeger-demo.jar"]
