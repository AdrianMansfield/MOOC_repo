DROP DATABASE IF EXISTS moocproject;
CREATE DATABASE moocproject;

CREATE USER moocuser with encrypted password 'root';
GRANT ALL ON DATABASE moocproject TO moocuser;