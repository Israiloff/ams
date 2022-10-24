FROM maven:3.6.3-openjdk-11 as build

RUN mkdir -p /root/.m2 && mkdir /root/.m2/repository
WORKDIR /root/.m2

COPY docker/settings.xml .
COPY pom.xml .
COPY mvnw .
RUN mvn clean
RUN mvn -B dependency:resolve

COPY src src
COPY lombok.config .
RUN mvn -B package

FROM eclipse-temurin:11.0.16_8-jre
RUN mkdir /app
COPY --from=build /root/.m2/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]