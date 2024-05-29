-- Ejemplo 1: Procedimiento Simple
CREATE OR REPLACE PROCEDURE greet_employee (p_employee_id IN NUMBER) IS
   v_employee_name employees.employee_name%TYPE;
BEGIN
   SELECT employee_name INTO v_employee_name
   FROM employees
   WHERE employee_id = p_employee_id;

   DBMS_OUTPUT.PUT_LINE('Hello, ' || v_employee_name);
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('No employee found with ID: ' || p_employee_id);
END greet_employee;
/

-- Para llamar al procedimiento:
BEGIN
   greet_employee(1001);
END;
/


-- Ejemplo 2: Procedimiento con Parámetros IN y OUT
-- Este procedimiento calcula el salario anual de un empleado y lo devuelve a través de un parámetro de salida.
CREATE OR REPLACE PROCEDURE calculate_annual_salary (
   p_employee_id IN NUMBER,
   p_annual_salary OUT NUMBER
) IS
   v_monthly_salary employees.salary%TYPE;
BEGIN
   SELECT salary INTO v_monthly_salary
   FROM employees
   WHERE employee_id = p_employee_id;
   
   p_annual_salary := v_monthly_salary * 12;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      p_annual_salary := NULL;
END calculate_annual_salary;
/

--Para llamar al procedimiento:
DECLARE
   v_annual_salary NUMBER;
BEGIN
   calculate_annual_salary(1001, v_annual_salary);
   DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_annual_salary);
END;
/


-- Ejemplo 3: Procedimiento con Parámetros IN OUT
-- Este procedimiento incrementa el salario de un empleado en un porcentaje dado y devuelve el nuevo salario.
CREATE OR REPLACE PROCEDURE increase_salary (
   p_employee_id IN NUMBER,
   p_percentage IN NUMBER,
   p_new_salary IN OUT NUMBER
) IS
BEGIN
   UPDATE employees
   SET salary = salary * (1 + p_percentage / 100)
   WHERE employee_id = p_employee_id
   RETURNING salary INTO p_new_salary;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      p_new_salary := NULL;
END increase_salary;
/

-- Para llamar al procedimiento:
DECLARE
   v_new_salary NUMBER;
BEGIN
   increase_salary(1001, 10, v_new_salary);
   DBMS_OUTPUT.PUT_LINE('New Salary: ' || v_new_salary);
END;
/


-- Ejemplo 4: Procedimiento para Insertar Datos
-- Este procedimiento inserta un nuevo empleado en la tabla employees.
CREATE OR REPLACE PROCEDURE add_employee (
   p_employee_id IN NUMBER,
   p_employee_name IN VARCHAR2,
   p_salary IN NUMBER,
   p_department_id IN NUMBER
) IS
BEGIN
   INSERT INTO employees (employee_id, employee_name, salary, department_id)
   VALUES (p_employee_id, p_employee_name, p_salary, p_department_id);
EXCEPTION
   WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Employee ID already exists: ' || p_employee_id);
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END add_employee;
/

-- Para llamar al procedimiento:
BEGIN
   add_employee(1002, 'Jane Doe', 3500, 10);
END;
/


-- Ejemplo 5: Procedimiento para Eliminar Datos
CREATE OR REPLACE PROCEDURE delete_employee (p_employee_id IN NUMBER) IS
BEGIN
   DELETE FROM employees
   WHERE employee_id = p_employee_id;
   IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No employee found with ID: ' || p_employee_id);
   ELSE
      DBMS_OUTPUT.PUT_LINE('Employee deleted: ' || p_employee_id);
   END IF;
EXCEPTION
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END delete_employee;
/

-- Para llamar al procedimiento:
BEGIN
   delete_employee(1002);
END;
/
