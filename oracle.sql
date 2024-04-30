sqlplus sys as sysdba
    show user con_name
    create user c##alexey identified by alexey default tablespace users;
    > User created.
    grant connect, resource, DBA to c##alexey;
    > Grant suceeded. 

sqlplus c##alexey/alexey;
connect c##alexey/alexey;


sqlplus sys as sysdba
create user suzdalenko identified by suzdalenko default tablespace users;
grant connect, resource, DBA to suzdalenko;
conn suzdalenko/suzdalenko;