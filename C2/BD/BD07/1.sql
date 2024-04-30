SET SERVEROUTPUT ON;
-- 1. Crea el tipo de objetos "Personal"
                                                                                DROP TYPE Personal FORCE;
CREATE OR REPLACE TYPE Personal AS OBJECT(
    codigo INTEGER,
    dni VARCHAR2(10),
    nombre VARCHAR2(30),
    apellidos VARCHAR2(30),
    sexo VARCHAR2(1),
    fecha_nac DATE
) NOT FINAL;
/
                                                                                DROP TYPE Responsable FORCE;
-- Crea, como tipo heredado de "Personal", el tipo de objeto "Responsable" 
CREATE OR REPLACE TYPE Responsable UNDER Personal (
    tipo CHAR,
    antiguedad INTEGER,
     CONSTRUCTOR FUNCTION Responsable(
        codigo INTEGER,
        nombre VARCHAR2,
        primer_apellido VARCHAR2,
        segundo_apellido VARCHAR2,
        tipo CHAR
    ) RETURN SELF AS RESULT,
    MEMBER FUNCTION getNombreCompleto RETURN VARCHAR2
);
/
                                                                                DROP TYPE Zonas FORCE;
-- Crea el tipo de objeto "Zonas"
CREATE OR REPLACE TYPE Zonas AS OBJECT(
    codigo INTEGER, 
    nombre VARCHAR2(20), 
    refRespon REF Responsable, 
    codigoPostal CHAR(5),
    MEMBER FUNCTION ordenarZonas RETURN VARCHAR2
) NOT FINAL;
/
CREATE OR REPLACE TYPE BODY Zonas AS
    MEMBER FUNCTION ordenarZonas RETURN VARCHAR2 IS
    BEGIN
        RETURN 'ok';
    END ordenarZonas;
END;
/
-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
DECLARE
    res Responsable;
    zona Zonas;
BEGIN
    res  := Responsable(null, null, null, null, null);
    zona := Zonas      (null, null, REF(res), null);
    DBMS_OUTPUT.PUT_LINE('res=' || res.getNombreCompleto );
END;
/
-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                                                                               DROP TYPE Comercial FORCE;
-- Crea, como tipo heredado de "Personal", el tipo de objeto "Comercial"
CREATE OR REPLACE TYPE Comercial UNDER Personal(
    zonaComercial Zonas
);
/



-- 2. Crea un método constructor para el tipo de objetos "Responsable"
CREATE OR REPLACE TYPE BODY Responsable AS
    CONSTRUCTOR FUNCTION Responsable(
        codigo INTEGER,
        nombre VARCHAR2,
        primer_apellido VARCHAR2,
        segundo_apellido VARCHAR2,
        tipo CHAR
    ) RETURN SELF AS RESULT IS
    BEGIN
        SELF.codigo := codigo;
        SELF.nombre := nombre;
        SELF.apellidos := primer_apellido || ' ' || segundo_apellido;
        SELF.tipo := tipo;
        RETURN;
    END;
    
    -- 3. Crea un método getNombreCompleto para el tipo de objetos Responsable    
    MEMBER FUNCTION getNombreCompleto RETURN VARCHAR2 IS
    BEGIN
        RETURN apellidos || ' ' || nombre;
    END getNombreCompleto;
END;
/



-- 4. Crea un tabla TablaResponsables de objetos  Responsable y insertat datos
                                                                                DROP TABLE TablaResponsables;
CREATE TABLE TablaResponsables OF Responsable;
INSERT INTO TablaResponsables VALUES (Responsable(5, '51083099F', 'ELENA', 'POSTA LLANOS', 'F', '31/03/1975', 'N', 4));
/
DECLARE
    res Responsable;
BEGIN
    res := Responsable(6, 'JAVIER', 'JARAMILLO', 'HERNANDEZ', 'C');
    INSERT INTO TablaResponsables VALUES (res);
END;
/



                                                                                DROP TYPE ListaZonas FORCE;
-- 5. Crea una colección VARRAY llamada ListaZonas 
CREATE OR REPLACE TYPE ListaZonas AS VARRAY(10) OF Zonas;
/
DECLARE
    listaZonas1 ListaZonas := ListaZonas();
    res Responsable;
    ref_responsable1 REF Responsable;
    ref_responsable2 REF Responsable;
    unComercial Comercial;
BEGIN
    SELECT REF(r) INTO ref_responsable1 FROM TablaResponsables r WHERE r.codigo = 5;
    SELECT REF(r) INTO ref_responsable2 FROM TablaResponsables r WHERE r.dni = '51083099F';
    listaZonas1.EXTEND(2);
    listaZonas1(1) := Zonas(1, 'zona 1', ref_responsable1, '06834');
    listaZonas1(2) := Zonas(2, 'zona 2', ref_responsable2, '28003');
    
    -- 6. Crea una tabla TablaComerciales de objetos Comercial y inserta datos del varray listadoZonas
    EXECUTE IMMEDIATE 'DROP TABLE TablaComerciales';
    EXECUTE IMMEDIATE 'CREATE TABLE TablaComerciales  OF Comercial';
    INSERT INTO TablaComerciales VALUES (Comercial(100, '23401092Z', 'MARCOS', 'SUAREZ LOPEZ', 'M', TO_DATE('30/3/1990', 'DD/MM/YYYY'), listaZonas1(1)));
    INSERT INTO TablaComerciales VALUES (Comercial(102, '6932288V', 'ANASTASIA', 'GOMES PEREZ', 'F', TO_DATE('28/11/1984', 'DD/MM/YYYY'), listaZonas1(2)));
    
    -- 7. Obtener, de la tabla TablaComerciales, el Comercial que tiene el código 100
    --SELECT VALUE(c) INTO unComercial FROM TablaComerciales c WHERE c.codigo = 100;
    DBMS_OUTPUT.PUT_LINE('comercial codigo=' || unComercial.codigo);
    
    --8. Modifica el código del Comercial guardado en esa variable unComercial
    --unComercial.codigo := 101;
    --unComercial.zonaComercial := listaZonas1(2);
    --INSERT INTO TablaComerciales VALUES(unComercial);
END;
/

--DROP TABLE TablaComerciales;








