FROM openjdk:14-alpine

COPY ./target/mongo-springboot-0.0.1-SNAPSHOT.jar /home/usr/

WORKDIR /home/usr/

CMD ["java", "-jar", "mongo-springboot-0.0.1-SNAPSHOT.jar"]