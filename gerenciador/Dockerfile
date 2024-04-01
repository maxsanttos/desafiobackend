# Estágio de construção
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests=true

# Estágio de execução
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/gerenciador-0.0.1-SNAPSHOT.jar desafio.jar
EXPOSE 8080
CMD ["java", "-jar", "desafio.jar"]
