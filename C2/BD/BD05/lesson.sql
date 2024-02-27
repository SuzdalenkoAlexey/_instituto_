sqlplus sys as sysdba

CREATE USER ALEXEY IDENTIFIED BY ALEXEY;

GRANT CONNECT, RESOURCE, DBA TO ALEXEY;

CREATE TABLESPACE suzdalenko_tablespace
   DATAFILE 'suzdalenko_tablespace.dbf' SIZE 100M AUTOEXTEND ON;

ALTER USER alexey DEFAULT TABLESPACE suzdalenko_tablespace;
