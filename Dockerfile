FROM openjdk:17
EXPOSE 8080
ADD target/translate-app.jar translate-app.jar
ENTRYPOINT ["java","-jar","/translate-app.jar"]