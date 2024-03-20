CREATE OR REPLACE PROCEDURE CambiarAgentesFamilia(id_FamiliaOrigen NUMBER, id_FamiliaDestino NUMBER) AS
   v_familia_origen VARCHAR(255);
   v_familia_destino VARCHAR(255);
   v_numero_agentes NUMBER  := 0;
   v_NumAgentes NUMBER      := 0;
   v_hay_errores BOOLEAN    := FALSE;
BEGIN
   --comprobamos que las familias existen (si no existen salta error NO DATA FOUND)
   SELECT nombre INTO v_familia_origen FROM familias WHERE identificador = id_FamiliaOrigen;
   SELECT nombre INTO v_familia_destino FROM familias WHERE identificador = id_FamiliaDestino;
 
   IF id_FamiliaOrigen = id_FamiliaDestino THEN
        v_hay_errores := TRUE;
        RAISE_APPLICATION_ERROR(-20001, 'Las familias no pueden ser iguales');
   END IF;
   
   -- si no tengo errores Cambio de los agentes de la familia origen a la familia destino
   IF  v_hay_errores = FALSE THEN
        --UPDATE agentes SET familia = id_FamiliaDestino WHERE familia = id_FamiliaOrigen;
        --v_NumAgentes := SQL%ROWCOUNT;
        DBMS_OUTPUT.PUT_LINE('Se han trasladado '||v_NumAgentes||' agentes de la familia '||v_familia_origen||' a la familia '||v_familia_destino);
   END IF;
   
   DBMS_OUTPUT.PUT_LINE('aun que hay errores de ejecucion el codigo continua !!!!!');

END;
/



DECLARE 
BEGIN
   CambiarAgentesFamilia(1, 11);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR SUZDALENKO: ' || SQLCODE || ' - ' || SQLERRM);
END;
/

select * from agentes;