FROM openjdk:17
ARG JAR_FILE=msclientes/target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'

# Passa esta variável de ambiente para o container que será utilizada no application.yml da aplicação
ARG EUREKA_SERVER=localhost

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#ENTRYPOINT java -jar -Dspring.profiles.active=production app.jar