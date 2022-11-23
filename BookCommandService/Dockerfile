FROM maven:3-amazoncorretto-17 AS maven_build

COPY pom.xml /tmp/

COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn package

FROM openjdk

EXPOSE 9090

CMD java -jar /data/BookCommandService.jar

COPY --from=maven_build /tmp/target/BookCommandService.jar /data/BookCommandService.jar
