
FROM eclipse-temurin:21-jdk

LABEL "org.opencontainers.image.authors"="yassine.com"

COPY target/gatewayserver-0.0.1-SNAPSHOT.jar  gatewayserver-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "gatewayserver-0.0.1-SNAPSHOT.jar"]