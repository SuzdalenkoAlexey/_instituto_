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

BEGIN
   greet_employee(1001);
END;
/
