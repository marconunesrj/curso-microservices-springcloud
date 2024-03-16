FROM openjdk:17
ARG JAR_FILE=mscloudgateway/target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'

# Passa estas variáveis de ambiente para o container que serão utilizadas no application-production.yml da aplicação
ARG EUREKA_SERVER=localhost
ARG KEYCLOAK_SERVER=cursoms-keycloak
# A mesma porta do keycloak no Docker
ARG KEYCLOAK_PORT=8080

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT java -jar app.jar