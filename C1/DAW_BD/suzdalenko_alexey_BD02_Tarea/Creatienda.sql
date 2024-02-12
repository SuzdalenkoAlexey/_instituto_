-- sqlplus c##alexey/alexey
-- start "C:\_instituto_\DAW_BD\Creatienda.sql"
-- TABLA FAMILIA Contiene las familias a las que pertenecen los productos, como por ejemplo ordenadores, impresoras,etc.
CREATE TABLE FAMILIA(
    Codfamilia NUMERIC(3) PRIMARY KEY,
    Denofamilia VARCHAR2(50) UNIQUE NOT NULL
);

COMMENT ON COLUMN FAMILIA.Codfamilia IS 'Código que distingue una familia de otra';
COMMENT ON COLUMN FAMILIA.Denofamilia IS 'Denominación de la familia';


-- TABLA PRODUCTO contendrá información general sobre los productos que distribuye la empresa a las tiendas.
CREATE TABLE PRODUCTO(
    Codproducto NUMERIC(5) PRIMARY KEY,
    Denoproducto VARCHAR2(20)NOT NULL,
    Descripcion VARCHAR2(100),
    PrecioBase NUMBER(6,2) CHECK (PrecioBase > 0) NOT NULL,
    PorcReposicion NUMERIC(3) CHECK (PorcReposicion > 0),
    UnidadesMinimas NUMERIC(4) CHECK (UnidadesMinimas > 0),
    Codfamilia NUMERIC(3) CONSTRAINT Cod_Fam_FK REFERENCES FAMILIA(Codfamilia) NOT NULL
);


-- TABLA TIENDA: contendrá información básica sobre las tiendas que distribuyen los productos.

CREATE TABLE TIENDA(
    Codtienda NUMERIC(3) PRIMARY KEY,
    Denotienda VARCHAR(20) NOT NULL,
    Telefono VARCHAR(11),
    CodigoPostal VARCHAR(5) NOT NULL,
    Provincia VARCHAR(5) NOT NULL
);


-- TABLA STOCK => Contendrá para cada tienda el número de unidades disponibles de cada producto. La clave primaria está formada por la concatenación de los campos Codtienda y Codproducto.

CREATE TABLE STOCK(
    Codtienda NUMERIC(3) CONSTRAINT Cod_Tie_FK REFERENCES TIENDA(Codtienda) NOT NULL,
    Codproducto NUMERIC(5) CONSTRAINT Cod_Pro_FK REFERENCES PRODUCTO(Codproducto) NOT NULL,
    Unidades NUMERIC(6) CHECK(Unidades >= 0) NOT NULL,
    CONSTRAINT Sto_PK PRIMARY KEY(Codtienda,Codproducto)
);




