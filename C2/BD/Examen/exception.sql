BEGIN
   -- Main logic
   SELECT employee_name INTO v_employee_name
   FROM employees
   WHERE employee_id = 1001;
   DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_employee_name);
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('No employee found with ID: 1001');
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('An unexpected error occurred.');
END;
/
