FROM openjdk:11
COPY target/fixing-solutions-0.0.1-SNAPSHOT.war app.jar
ENTRYPOINT ["java","-jar","/app.jar"]