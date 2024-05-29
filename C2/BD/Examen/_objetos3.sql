--Tipo de Objeto Base Person
CREATE OR REPLACE TYPE Person AS OBJECT (
   person_id NUMBER,
   person_name VARCHAR2(100),
   MEMBER PROCEDURE display_info
);
/
--Cuerpo del Tipo de Objeto Person
CREATE OR REPLACE TYPE BODY Person IS
   MEMBER PROCEDURE display_info IS
   BEGIN
      DBMS_OUTPUT.PUT_LINE('ID: ' || person_id || ', Name: ' || person_name);
   END display_info;
END;
/
-- Tipo de Objeto Derivado Employee con Herencia
CREATE OR REPLACE TYPE Employee UNDER Person (
   salary NUMBER,
   MEMBER FUNCTION get_annual_salary RETURN NUMBER,
   OVERRIDING MEMBER PROCEDURE display_info
);
/
-- Cuerpo del Tipo de Objeto Employee
CREATE OR REPLACE TYPE BODY Employee IS
   MEMBER FUNCTION get_annual_salary RETURN NUMBER IS
   BEGIN
      RETURN salary * 12;
   END get_annual_salary;
   
   OVERRIDING MEMBER PROCEDURE display_info IS
   BEGIN
      DBMS_OUTPUT.PUT_LINE('ID: ' || person_id || ', Name: ' || person_name || ', Salary: ' || salary);
   END display_info;
END;
/
-- Tipo de Tabla de Objetos Employees
CREATE OR REPLACE TYPE Employees AS TABLE OF Employee;
/
--Tabla Departments
CREATE TABLE departments (
   department_id NUMBER PRIMARY KEY,
   department_name VARCHAR2(100),
   employees Employees
) NESTED TABLE employees STORE AS employees_nt;

--Paso 4: Insertar Datos en la Tabla de Colección
DECLARE
   v_employees Employees := Employees();
BEGIN
   v_employees.EXTEND;
   v_employees(1) := Employee(1, 'John Doe', 3000);
   
   v_employees.EXTEND;
   v_employees(2) := Employee(2, 'Jane Smith', 4000);
   
   INSERT INTO departments VALUES (1, 'HR', v_employees);
   
   v_employees.DELETE;
   
   v_employees.EXTEND;
   v_employees(1) := Employee(3, 'Alice Brown', 5000);
   
   v_employees.EXTEND;
   v_employees(2) := Employee(4, 'Bob White', 4500);
   
   INSERT INTO departments VALUES (2, 'Finance', v_employees);
END;
/

-- Paso 5: Consultar y Usar Métodos de Objetos en una Colección
DECLARE
   v_departments_cursor SYS_REFCURSOR;
   v_department_id NUMBER;
   v_department_name VARCHAR2(100);
   v_employees Employees;
   v_employee Employee;
   v_annual_salary NUMBER;
BEGIN
   OPEN v_departments_cursor FOR
      SELECT department_id, department_name, employees
      FROM departments;
   
   LOOP
      FETCH v_departments_cursor INTO v_department_id, v_department_name, v_employees;
      EXIT WHEN v_departments_cursor%NOTFOUND;
      
      DBMS_OUTPUT.PUT_LINE('Department ID: ' || v_department_id || ', Name: ' || v_department_name);
      
      FOR i IN 1 .. v_employees.COUNT LOOP
         v_employee := v_employees(i);
         v_employee.display_info;
         
         v_annual_salary := v_employee.get_annual_salary;
         DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_annual_salary);
      END LOOP;
   END LOOP;
   
   CLOSE v_departments_cursor;
END;
/

