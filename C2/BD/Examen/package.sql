CREATE OR REPLACE PACKAGE employee_pkg IS
   PROCEDURE greet_employee (p_employee_id IN NUMBER);
   FUNCTION get_employee_salary (p_employee_id IN NUMBER) RETURN NUMBER;
END employee_pkg;
/

CREATE OR REPLACE PACKAGE BODY employee_pkg IS
   PROCEDURE greet_employee (p_employee_id IN NUMBER) IS
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

   FUNCTION get_employee_salary (p_employee_id IN NUMBER) RETURN NUMBER IS
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
END employee_pkg;
/

BEGIN
   employee_pkg.greet_employee(1001);

   DECLARE
      v_salary NUMBER;
   BEGIN
      v_salary := employee_pkg.get_employee_salary(1001);
      IF v_salary IS NOT NULL THEN
         DBMS_OUTPUT.PUT_LINE('Employee Salary: ' || v_salary);
      ELSE
         DBMS_OUTPUT.PUT_LINE('No salary found for the given employee ID.');
      END IF;
   END;
END;
/
