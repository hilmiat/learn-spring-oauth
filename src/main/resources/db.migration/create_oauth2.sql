CREATE TABLE OAUTH_CLIENT_DETAILS(
CLIENT_ID VARCHAR(255) PRIMARY KEY,
RESOURCE_IDS VARCHAR (255),
CLIENT_SECRET VARCHAR (255),
SCOPE VARCHAR (255),
AUTHORIZATION_GRANT_TYPES VARCHAR (255),
WEB_SERVER_REDIRECT_URI VARCHAR (255),
AUTHORITIES VARCHAR (255),
ACCESS_TOKEN_VALIDITY INTEGER,
REFRESH_TOKEN_VALIDITY INTEGER,
ADDITIONAL_INFORMATION VARCHAR (4096),
AUTOAPPROVE VARCHAR (255)
);

INSERT INTO OAUTH_CLIENT_DETAILS(
CLIENT_ID,
RESOURCE_IDS,
SCOPE,
AUTHORIZATION_GRANT_TYPES,
ACCESS_TOKEN_VALIDITY,
REFRESH_TOKEN_VALIDITY)
VALUES (
'myapp',
'api',
'$2a$10$7Xu6TM5VVZIMU3bRLZreK.vQqSpaPDbLKy4QZI2PZmuCu32awSV4S',
'read',
'password,refresh_token',300,600
)

CREATE TABLE OAUTH_CLIENT_TOKEN(
TOKEN_ID VARCHAR (255),
TOKEN BLOB,
AUTHENTICATION_ID VARCHAR (255) PRIMARY KEY,
USER_NAME VARCHAR (255),
CLIENT_ID VARCHAR (255)
);

CREATE TABLE OAUTH_ACCESS_TOKEN(
TOKEN_ID VARCHAR (255),
TOKEN BLOB,
AUTHENTICATION_ID VARCHAR (255) PRIMARY KEY,
USER_NAME VARCHAR (255),
CLIENT_ID VARCHAR (255),
AUTHENTICATION BLOB,
REFRESH_TOKEN VARCHAR (255)
);

CREATE TABLE OAUTH_REFRESH_TOKEN(
TOKEN_ID VARCHAR (255),
TOKEN BLOB,
AUTHENTICATION BLOB
);

CREATE TABLE OAUTH_CODE(
CODE VARCHAR (255),
AUTHENTICATION BLOB
);

CREATE TABLE OAUTH_APPROVALS(
USERID VARCHAR(255),
CLIENTID VARCHAR (255),
SCOPE VARCHAR (255),
STATUS VARCHAR (255),
EXPIRESAT TIMESTAMP ,
LASTMODIFIEDAT TIMESTAMP
);