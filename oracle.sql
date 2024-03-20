sqlplus sys as sysdba
    show user con_name
    create user c##alexey identified by alexey default tablespace users;
    > User created.
    grant connect, resource, DBA to c##alexey;
    > Grant suceeded. 

sqlplus c##alexey/alexey;
connect c##alexey/alexey;


drop user c##agencia cascade;
create user c##agencia identified by agencia default tablespace users;
grant connect,resource,dba to c##agencia;
conn c##agencia/agencia
