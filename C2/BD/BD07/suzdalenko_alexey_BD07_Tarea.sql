SET SERVEROUTPUT ON;
begin 
    begin
        execute immediate 'drop table TablaComerciales force';
    exception
        when others then null;
    end;
    begin
        execute immediate 'drop type Zonas force';
    exception
        when others then null;
    end;
    begin
        execute immediate 'drop table TablaResponsables force';
    exception
        when others then null;
    end;
    execute immediate 'drop type Comercial force';
    execute immediate 'drop type Zonas force';
    execute immediate 'drop type Responsable force';
    execute immediate 'drop type Personal force';
    
exception
    when others then null;
end;
/


--1. Crea el tipo de objetos "Personal" con los siguientes atributos:
create or replace type Personal as object (
    codigo INTEGER, dni VARCHAR2(10), nombre VARCHAR2(30), apellidos VARCHAR2(30), sexo VARCHAR2(1), fecha_nac DATE
) not final;
/
-- Crea, como tipo heredado de "Personal", el tipo de objeto "Responsable" con los siguientes atributos:
create or replace type Responsable under Personal(
    tipo CHAR, antiguedad INTEGER,
    constructor function Responsable(
        codigo INTEGER, nombre VARCHAR2, primerApellido VARCHAR, segundoApellido VARCHAR, tipo CHAR
    ) return self as result,
    member function getNombreCompleto return VARCHAR
);
/
--Crea el tipo de objeto "Zonas" con los siguientes atributos:
create or replace type Zonas as object(
    codigo INTEGER, nombre VARCHAR2(20), refRespon REF Responsable, codigoPostal CHAR(5),
    member function ordenarZonas return VARCHAR2
) not final;
/
--Crea, como tipo heredado de "Personal", el tipo de objeto "Comercial" con los siguientes atributos:
create or replace type Comercial under Personal(
    zonaComercial Zonas
);
/



--2. Crea un método constructor para el tipo de objetos "Responsable", en el que se indiquen como parámetros el código, nombre, primer apellido, segundo apellido y tipo. Este método debe asignar al atributo apellidos los datos de primer apellido y segundo apellido que se han pasado como parámetros, uniéndolos con un espacio entre ellos.
create or replace type body Responsable as constructor function Responsable(
    codigo INTEGER, nombre VARCHAR2, primerApellido VARCHAR, segundoApellido VARCHAR, tipo CHAR
) return self as result is
    begin
        self.codigo := codigo;
        self.nombre := nombre;
        self.apellidos := primerApellido || ' ' || segundoApellido;
        self.tipo := tipo;
        return;
    end;
    --3. Crea un método getNombreCompleto para el tipo de objetos Responsable que permita obtener su nombre completo con el formato apellidos nombre
    member function getNombreCompleto return VARCHAR is
    begin
        return  self.apellidos || ' ' || self.nombre;
    end getNombreCompleto;
end;
/



--4. Crea un tabla TablaResponsables de objetos  Responsable. Inserta en dicha tabla dos objetos  Responsable. 
create table TablaResponsables of Responsable;
insert into TablaResponsables (codigo,dni,nombre,apellidos,sexo,fecha_nac,tipo,antiguedad) VALUES (5,'51083099F','ELENA','POSTA LLANOS','F','31/03/1975','N',4);
/
declare
    nuevo_responsable Responsable;
begin
    --El segundo objeto "Responsable" debes crearlo usando el método constructor que has realizado anteriormente. Debes usar los siguientes datos:
    nuevo_responsable := Responsable(6, 'JAVIER', 'JARAMILLO', 'HERNANDEZ', 'C');
    insert into TablaResponsables values (nuevo_responsable);
end;
/
--6 Crea una tabla TablaComerciales de objetos Comercial. Inserta en dicha tabla las siguientes filas:
create table TablaComerciales of Comercial;
/
--5. Crea una colección VARRAY llamada ListaZonas en la que se puedan almacenar hasta 10 objetos Zonas. . Guarda en una instancia listaZonas1 de dicha lista, dos Zonas
create or replace type ListaZonas as VARRAY(10) of Zonas;
/
declare
    listaZonas1 ListaZonas := ListaZonas();
    ref_responsable1 REF Responsable;
    ref_responsable2 REF Responsable;
    com1 Comercial;
    com2 Comercial;
    unComercial Comercial;
begin
    SELECT REF(r) INTO ref_responsable1 FROM TablaResponsables r WHERE r.codigo = 5;
    SELECT REF(r) INTO ref_responsable2 FROM TablaResponsables r WHERE r.dni = '51083099F';
    listaZonas1.EXTEND(2);
    listaZonas1(1) := Zonas(1, 'zona 1', ref_responsable1, '06834');
    listaZonas1(2) := Zonas(2, 'zona 2', ref_responsable2, '28003');
    
    
    
    --6 Crea una tabla TablaComerciales de objetos Comercial. Inserta en dicha tabla las siguientes filas:
    com1 := Comercial(100, '23401092Z', 'MARCOS', 'SUAREZ LOPEZ', 'M', TO_DATE('30/03/1990', 'DD/MM/YYYY'), listaZonas1(1));
    com2 := Comercial(102, '6932288V', 'ANASTASIA', 'GOMES PEREZ', 'F', TO_DATE('28/11/1984', 'DD/MM/YYYY'), listaZonas1(2));
    INSERT INTO TablaComerciales VALUES (com1);
    INSERT INTO TablaComerciales VALUES (com2);
    
    
    
    --7.  Obtener, de la tabla TablaComerciales, el Comercial que tiene el código 100, asignándoselo a una variable unComercial 
    SELECT VALUE(c) INTO unComercial FROM TablaComerciales c WHERE c.codigo = 100;
    
    
    --8. Modifica el código del Comercial guardado en esa variable unComercial asignando el valor 101, y su zona debe ser la segunda que se había creado anteriormente. Inserta ese Comercial en la tabla TablaComerciales
    unComercial.codigo := 101;
    unComercial.zonaComercial := listaZonas1(2);
    INSERT INTO TablaComerciales VALUES (unComercial);
    DBMS_OUTPUT.PUT_LINE(unComercial.codigo);
end;
/



--9. Crea un método MAP ordenarZonas para el tipo Zonas. Este método debe retornar el nombre completo del Responsable al que hace referencia cada zona. Para obtener el nombre debes utilizar el método getNombreCompleto que se ha creado anteriormente
create or replace type body Zonas as
    -- Método MAP para ordenarZonas
    member function ordenarZonas return VARCHAR2 is
        responsableNombreCompleto VARCHAR2(100);
        refResponsable REF Responsable;
        res Responsable;
    begin
        -- Obtén la referencia al responsable
        refResponsable := self.refRespon;
        -- Obtén el responsable
        SELECT DEREF(refResponsable) INTO res FROM DUAL;
        -- Obtén el nombre completo del responsable utilizando el método getNombreCompleto
        responsableNombreCompleto := res.getNombreCompleto();
        -- Retorna el nombre completo del responsable
        return responsableNombreCompleto;
    end ordenarZonas;
end;
/


--10. Realiza una consulta de la tabla TablaComerciales ordenada por zonaComercial para comprobar el funcionamiento del método MAP.  
SELECT c.codigo, c.nombre, c.apellidos, c.zonaComercial.ordenarZonas() as NombreResponsable
FROM TablaComerciales c
ORDER BY c.zonaComercial.codigo;





