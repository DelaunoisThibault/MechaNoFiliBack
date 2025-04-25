FROM maven:3.9.6-eclipse-temurin-17 as build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN nmvn package -DskipTests

FROM eclipse-temurin:17-jdk-jammy as runtime

WORKDIR /app

COPY --from=build /app/target/*jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]