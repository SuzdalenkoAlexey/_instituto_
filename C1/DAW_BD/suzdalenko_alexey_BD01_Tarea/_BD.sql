# ABRIR CMD COMO ADMINISTRADOR
// Nos conectamos en SQLPLUS como administradores con la sentencia
sqlplus sys as sysdba
// Para mostrar el usuario y la base de datos actual utilizamos el comando show
show user con_name
// creacion de usuario
create user c##alexey identified by alexey default tablespace users;
// concedemos permiso para conectar y crear objetos ejecutando la sentencia:
grant connect, resource, DBA to c##alexey;
// conectamos con el usuario c##nuria con la sentencia
CONNECT c##alexey/alexey
// Mostramos el contenedor y el usuario con el comando
show user con_name
exit
sqlplus c##alexey/alexey