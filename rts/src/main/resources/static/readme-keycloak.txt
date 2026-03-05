
================================RealM keyloak setup====================
->Download keyloak.zip from -> https://www.keycloak.org/downloads
->extract in C:
-> Run cmd as Admin and run below command to setup admin creds
->Go to bin folder->
->set:KC_BOOTSTRAP_ADMIN_USERNAME="admin"
->set:KC_BOOTSTRAP_ADMIN_PASSWORD="admin"
-> .\kc.bat start-dev    ==>(to start dev mode)
-> .\kc.bat start-dev --http-port 8181    ==>(to change port)

-> to access RealMe console url
http://localhost:8181/admin     -> admin console
http://localhost:8181           -> User console

Note: keyload uses H2 db by default to stored user details. We can use our mysql db using below steps.
->put mysql-connector.jar in -C:\keycloak-26.5.4\providers\
->Run Queries:
CREATE DATABASE keycloak_db CHARACTER SET utf8 COLLATE utf8_unicode_ci;
CREATE USER 'keycloak'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON keycloak_db.* TO 'keycloak'@'localhost';
FLUSH PRIVILEGES;

->go to C:\keycloak-26.5.4\conf and edit keyload.conf file
->change this details:
db=mysql
db-url=jdbc:mysql://localhost:3306/keycloak_db?useSSL=false&allowPublicKeyRetrieval=true
db-username=keycloak
db-password=your_password
# log-level=info,org.hibernate.SQL:debug 

->build again and run
->.\kc.bat build
-> .\kc.bat start-dev --http-port 8181

--> to create user it will ask to create admin user first and then create other users
--> Once keycloak server started it will create muliple tables in database,
--> general info tables
select * from REALM;
select * from CLIENT;
select * from USER_ATTRIBUTE;
select * from USER_GROUP_MEMBERSHIP;

SELECT * FROM user_entity; 
SELECT * FROM CREDENTIAL WHERE TYPE='password'; 
SELECT * FROM keycloak_role;
SELECT * from USER_ROLE_MAPPING;


logout->
http://localhost:8181/realms/rts-realme/protocol/openid-connect/logout?redirect_uri=http://localhost:4200

