-- Ejemplo de Cursor Implícito
BEGIN
   FOR record IN (SELECT employee_name, salary FROM employees WHERE department_id = 10) LOOP
      DBMS_OUTPUT.PUT_LINE('Employee: ' || record.employee_name || ', Salary: ' || record.salary);
   END LOOP;
END;
/

-- Ejemplo de Cursor Explícito
-- Primero, declaramos el cursor en la sección de declaración del bloque PL/SQL.
DECLARE
   CURSOR emp_cursor IS
      SELECT employee_name, salary
      FROM employees
      WHERE department_id = 10;
   v_employee_name employees.employee_name%TYPE;
   v_salary employees.salary%TYPE;
BEGIN
   -- Abrir el cursor
   OPEN emp_cursor;
   
   -- Recuperar cada registro del cursor
   LOOP
      FETCH emp_cursor INTO v_employee_name, v_salary;
      EXIT WHEN emp_cursor%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('Employee: ' || v_employee_name || ', Salary: ' || v_salary);
   END LOOP;
   
   -- Cerrar el cursor
   CLOSE emp_cursor;
END;
/


-- Ejemplo de Cursor con Parámetros
DECLARE
   CURSOR emp_cursor (p_department_id NUMBER) IS
      SELECT employee_name, salary
      FROM employees
      WHERE department_id = p_department_id;
   v_employee_name employees.employee_name%TYPE;
   v_salary employees.salary%TYPE;
BEGIN
   -- Abrir el cursor con un parámetro
   OPEN emp_cursor(10);
   
   -- Recuperar cada registro del cursor
   LOOP
      FETCH emp_cursor INTO v_employee_name, v_salary;
      EXIT WHEN emp_cursor%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('Employee: ' || v_employee_name || ', Salary: ' || v_salary);
   END LOOP;
   
   -- Cerrar el cursor
   CLOSE emp_cursor;
END;
/


-- Cursores y Manejo de Excepciones
DECLARE
   CURSOR emp_cursor IS
      SELECT employee_name, salary
      FROM employees
      WHERE department_id = 10;
   v_employee_name employees.employee_name%TYPE;
   v_salary employees.salary%TYPE;
BEGIN
   OPEN emp_cursor;
   
   LOOP
      FETCH emp_cursor INTO v_employee_name, v_salary;
      EXIT WHEN emp_cursor%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('Employee: ' || v_employee_name || ', Salary: ' || v_salary);
   END LOOP;
   
   CLOSE emp_cursor;
EXCEPTION
   WHEN OTHERS THEN
      IF emp_cursor%ISOPEN THEN
         CLOSE emp_cursor;
      END IF;
      DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/
