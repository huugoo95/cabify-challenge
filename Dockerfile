FROM openjdk:11.0.3-jre-slim
VOLUME /tmp
COPY car-pooling-challenge/build/libs/car-pooling-challenge-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
