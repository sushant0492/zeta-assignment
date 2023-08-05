FROM eclipse-temurin:17-jdk-jammy
EXPOSE 9292
COPY /target/zeta-assignment-0.0.1-SNAPSHOT.jar zeta-assignment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","zeta-assignment-0.0.1-SNAPSHOT.jar"]