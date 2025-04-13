FROM openjdk:21
LABEL authors="nileema.shah"
WORKDIR /app
COPY ./target/cicd.jar /app
EXPOSE 8080
CMD ["java", "-jar", "cicd.jar"]