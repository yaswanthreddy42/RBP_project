FROM openjdk:11
EXPOSE 8081
COPY target/movieapplication.jar movieapplication.jar

ENTRYPOINT ["java","-jar","/movieapplication.jar"]