# Springboot_SSO
Springboot_SSO - single sign-on using springboot


Start Keycloak :
From a terminal, enter the following command to start Keycloak:

docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:25.0.1 start-dev

This command starts Keycloak exposed on the local port 8080 and creates an initial admin user with the username admin and password admin.

(Application name)Realm name: Springboot_SSO

Client ID :LoginWithKeyCloak
username:user_admin
password:admin

Step 1: Generate a Self-Signed Certificate
Generate the self-signed certificate and create a keystore:

keytool -genkeypair -alias migrate -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore migrate.p12 -validity 365 -ext SAN=DNS:localhost,IP:127.0.0.1

Example: PS C:\Users\Khadeer\Desktop\demo\demo\src\main\resources\keystore> keytool -genkeypair -alias migrate -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore migrate.p12 -validity 365 -ext SAN=DNS:localhost,IP:127.0.0.1
password:123465

keytool -genkeypair -alias migrate -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore migrate.p12 -validity 365 -ext SAN=DNS:localhost,IP:127.0.0.1,IP:212.227.185.126


Step 2: Export the Certificate
Export the certificate from the keystore:

keytool -exportcert -alias migrate -keystore migrate.p12 -rfc -file migrate.crt

Step 3: Create and Configure Truststore
Download the WSO2 server certificate and then import it into a new truststore:

keytool -importcert -alias wso2 -file wso2.crt -keystore truststore.jks -storepass truststor






