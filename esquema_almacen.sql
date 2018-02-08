
--GENERACIÓN DE LA PRIMER TABLA
CREATE TABLE ALMACEN
(
NUMERO_ALMACEN INTEGER, 
UBICACION_ALMACEN VARCHAR2(50),
CONSTRAINT PK_NUM_ALM PRIMARY KEY (NUMERO_ALMACEN)
);
-- Declaración de procedimiento
CREATE OR REPLACE PROCEDURE guardar_almacen(my_num_alm IN integer, my_ub_alm IN varchar2)
AS
-- Variables locales si se requieren
BEGIN
--Cuerpo o lógica del procedimiento
INSERT INTO ALMACEN VALUES(my_num_alm,my_ub_alm);
END;
/


--Usaremos un bloque PL-SQL para probar que esta bien nuestro procedimiento
BEGIN 
guardar_almacen (321,'ECATEPEC');
END;
/

SELECT * FROM ALMACEN

-- Probar el procedimiento con Netbeans


CREATE TABLE cliente( numero_cliente integer,
                      numero_almacen integer,
                      nombre_cliente varchar2(80),
                      constraint PK_n_c Primary Key (numero_cliente),
                      constraint FK1_n_a Foreign Key (numero_almacen) references almacen(numero_almacen));

CREATE TABLE vendedor(  numero_vendedor integer,
                        nombre_vendedor varchar2(80),
                        area_ventas varchar2(80),
                        constraint PK_n_v Primary Key (numero_vendedor));

CREATE TABLE ventas(  id_ventas integer,
                      numero_cliente integer,
                      numero_vendedor integer,
                      monto_venta float,
                      constraint PK_i_v Primary Key (id_ventas),
                      constraint FK1_n_c Foreign Key (numero_cliente) references cliente(numero_cliente),
                      constraint FK1_n_v Foreign Key (numero_vendedor) references vendedor(numero_vendedor));
                      
--PASOS PARA GENERAR UN PROCEDIMIENTO ALMACENADO PARA GUARDAR UNA FILA O REGISTRO DE UNA TABLA CON PK IMPUESTO O ARTIFICIAL
--1.GENERAR UNA SECUENCIA
--2.GENERAR UN PROCEDIMIENTO Y ASOCIARLO




--Ejemplo de tabla y procedimiento almacenado para guardar con PK impuesto o artificial
CREATE TABLE CALIFICACIONES(ID_CALIFICACION INTEGER, 
                            MATERIA VARCHAR2(80),
                            VALOR FLOAT,
                            CONSTRAINT PK_ID_CAL PRIMARY KEY (ID_CALIFICACION));

--Generamos una secuencia
CREATE SEQUENCE SEC_CALIFICACIONES
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

--PROCEDIMIENTO.......
CREATE OR REPLACE PROCEDURE GUARDAR_CALIFICACIONES( MY_ID_CALIFICACION OUT INTEGER,
                                                    MY_MATERIA IN VARCHAR2,
                                                    MY_VALOR IN FLOAT)
AS 
BEGIN
SELECT SEC_CALIFICACIONES.NEXTVAL INTO MY_ID_CALIFICACION FROM DUAL;
INSERT INTO CALIFICACIONES VALUES (MY_ID_CALIFICACION, MY_MATERIA, MY_VALOR);
END;
/
                  
                      