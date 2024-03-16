# https://www.keycloak.org/server/containers
FROM quay.io/keycloak/keycloak:20.0.0 as builder

# Enable health and metrics support
ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true

# Configure a database vendor
#ENV KC_DB=postgres
#ENV KC_DB=mysql
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin

WORKDIR /opt/keycloak
# for demonstration purposes only, please make sure to use proper certificates in production instead
#RUN keytool -genkeypair -storepass password -storetype PKCS12 -keyalg RSA -keysize 2048 -dname "CN=server" -alias server -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore conf/server.keystore
RUN /opt/keycloak/bin/kc.sh build

FROM quay.io/keycloak/keycloak:20.0.0
COPY --from=builder /opt/keycloak/ /opt/keycloak/

## Copiando o arquivo de configuração
#COPY keycloak/config/realm-export.json /opt/keycloak/data/import/
##RUN bash -c 'touch /opt/keycloak/data/import/realm-export.json'
#RUN cat /opt/keycloak/data/import/realm-export.json

# change these values to point to a running postgres instance
#ENV KC_DB=postgres
#ENV KC_DB_URL=jdbc:postgresql://postgres-db:5432/cursoms?currentSchema:postgres
#ENV KC_DB_USERNAME=postgres
#ENV KC_DB_PASSWORD=postgres
#ENV KC_DB=mysql
#ENV KC_DB_URL=jdbc:mysql://mysqldev:3315/meu_schema?createDatabaseIfNotExist=true&characterEncoding=UTF-8&rewriteBatchedStatements=true&enabledTLSProtocols=TLSv1,TLSv1.1,TLSv1.2
#ENV KC_DB_USERNAME=root
#ENV KC_DB_PASSWORD=root
ENV KC_HOSTNAME=localhost
ENV KC_HOSTNAME_PORT=8081
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin
ENV KC_LOG_LEVEL=info

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]