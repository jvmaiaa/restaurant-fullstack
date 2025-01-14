### Dockerfile
# Imagem base com Java 17
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR da aplicação para o container
COPY target/restaurant.jar restaurant.jar

# Define a porta exposta
EXPOSE 8081

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "restaurant.jar"]