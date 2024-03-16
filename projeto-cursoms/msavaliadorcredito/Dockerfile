FROM openjdk:17
ARG JAR_FILE=msavaliadorcredito/target/*.jar
#WORKDIR /app
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'

# Passa estas variáveis de ambiente para o container que serão utilizadas no application-production.yml da aplicação
ARG RABBITMQ_SERVER=cursoms-rabbitmq
ARG EUREKA_SERVER=localhost

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#ENTRYPOINT java -jar -Dspring.profiles.active=production app.jar