# ---- Stage 1: Build ----
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests
# ---- Stage 2: Tomcat ----
FROM tomcat:11.0.12-jdk21
RUN rm -rf /usr/local/tomcat/webapps/ROOT

#COPY --from=builder /app/target/demo-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]

LABEL authors="dotin"



