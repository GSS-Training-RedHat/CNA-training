
#create user jboss identified by redhat;

#grant CREATE SESSION, ALTER SESSION, CREATE DATABASE LINK,   CREATE MATERIALIZED VIEW, CREATE PROCEDURE, CREATE PUBLIC SYNONYM,   CREATE ROLE, CREATE SEQUENCE, CREATE SYNONYM, CREATE TABLE,   CREATE TRIGGER, CREATE TYPE, CREATE VIEW, UNLIMITED TABLESPACE   to jboss;


CREATE DATABASE   trainingdb;

CREATE  TABLE middleware (id int primary key,name varchar(255),logo varchar(255));
insert into middleware values(1,'EAP',null);
insert into middleware values(2,'Fuse',null);
insert into middleware values(3,'BRMS',null);
insert into middleware values(4,'Data Grid',null);
insert into middleware values(5,'JON',null);
insert into middleware values(6,'A-MQ',null);
