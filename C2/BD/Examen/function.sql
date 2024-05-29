CREATE OR REPLACE FUNCTION get_employee_salary (p_employee_id IN NUMBER) RETURN NUMBER IS
   v_salary employees.salary%TYPE;
BEGIN
   SELECT salary INTO v_salary
   FROM employees
   WHERE employee_id = p_employee_id;
   
   RETURN v_salary;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      RETURN NULL;
END get_employee_salary;
/

DECLARE
   v_salary NUMBER;
BEGIN
   v_salary := get_employee_salary(1001);
   IF v_salary IS NOT NULL THEN
      DBMS_OUTPUT.PUT_LINE('Employee Salary: ' || v_salary);
   ELSE
      DBMS_OUTPUT.PUT_LINE('No salary found for the given employee ID.');
   END IF;
END;
/


-- Función: Se llama como parte de una expresión debido a que retorna un valor. Por ejemplo:
DECLARE
   result NUMBER;
BEGIN
   result := my_function(10, 20);
END;
/

-- Procedimiento: Se llama como una declaración independiente. Por ejemplo:
BEGIN
   my_procedure(10, 20);
END;
/


-- Ejemplo de Función
CREATE OR REPLACE FUNCTION get_employee_salary (p_employee_id IN NUMBER) RETURN NUMBER IS
   v_salary employees.salary%TYPE;
BEGIN
   SELECT salary INTO v_salary
   FROM employees
   WHERE employee_id = p_employee_id;
   
   RETURN v_salary;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      RETURN NULL;
END get_employee_salary;
/

-- Llamada a la función:
DECLARE
   v_salary NUMBER;
BEGIN
   v_salary := get_employee_salary(1001);
   DBMS_OUTPUT.PUT_LINE('Employee Salary: ' || v_salary);
END;
/


-- Ejemplo de Procedimiento
CREATE OR REPLACE PROCEDURE update_employee_salary (
   p_employee_id IN NUMBER,
   p_new_salary IN NUMBER
) IS
BEGIN
   UPDATE employees
   SET salary = p_new_salary
   WHERE employee_id = p_employee_id;
   
   IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No employee found with ID: ' || p_employee_id);
   ELSE
      DBMS_OUTPUT.PUT_LINE('Salary updated for employee ID: ' || p_employee_id);
   END IF;
EXCEPTION
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END update_employee_salary;
/

-- Llamada al procedimiento:
BEGIN
   update_employee_salary(1001, 4000);
END;
/
