FROM maven:3.8.6-openjdk-11 as build

RUN mkdir -p /root/.m2 && mkdir /root/.m2/repository
WORKDIR /root/.m2
COPY .mvn .mvn
COPY settings.xml settings.xml

COPY ca.crt ca.crt
RUN keytool -importcert -keystore /usr/local/openjdk-11/lib/security/cacerts -storepass changeit -file ca.crt -alias "anorbank" -noprompt

COPY pom.xml .
COPY src src

RUN mvn clean package

# RUN mvn package

FROM eclipse-temurin:11.0.16_8-jre
RUN mkdir /app
COPY --from=build /root/.m2/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]