
FROM eclipse-temurin:21-jdk

LABEL "org.opencontainers.image.authors"="yassine.com"

COPY target/configserver-0.0.1-SNAPSHOT.jar  configserver-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java", "-jar", "configserver-0.0.1-SNAPSHOT.jar"]

