DECLARE
   -- Declaration section
   v_employee_name VARCHAR2(50);
   v_employee_id   NUMBER := 1001;
BEGIN
   -- Execution section
   SELECT employee_name INTO v_employee_name
   FROM employees
   WHERE employee_id = v_employee_id;
   
   DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_employee_name);
EXCEPTION
   -- Exception section
   WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('No employee found with ID: ' || v_employee_id);
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('An error occurred.');
END;
/

-- variables
DECLARE
   v_employee_id   NUMBER := 1001;
   v_employee_name VARCHAR2(50);
BEGIN
   v_employee_name := 'John Doe';
   DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_employee_name);
END;
/

-- if then else
DECLARE
   v_salary NUMBER := 3000;
BEGIN
   IF v_salary > 5000 THEN
      DBMS_OUTPUT.PUT_LINE('High salary');
   ELSIF v_salary BETWEEN 3000 AND 5000 THEN
      DBMS_OUTPUT.PUT_LINE('Medium salary');
   ELSE
      DBMS_OUTPUT.PUT_LINE('Low salary');
   END IF;
END;
/
-- loops
DECLARE
   v_counter NUMBER := 1;
BEGIN
   FOR i IN 1..5 LOOP
      DBMS_OUTPUT.PUT_LINE('Counter value: ' || i);
   END LOOP;

   WHILE v_counter <= 3 LOOP
      DBMS_OUTPUT.PUT_LINE('While Loop Counter: ' || v_counter);
      v_counter := v_counter + 1;
   END LOOP;
END;
/
-- cursor
BEGIN
   FOR record IN (SELECT employee_name FROM employees WHERE department_id = 10) LOOP
      DBMS_OUTPUT.PUT_LINE('Employee: ' || record.employee_name);
   END LOOP;
END;
/
DECLARE
   CURSOR emp_cursor IS
      SELECT employee_name
      FROM employees
      WHERE department_id = 10;
   v_employee_name employees.employee_name%TYPE;
BEGIN
   OPEN emp_cursor;
   LOOP
      FETCH emp_cursor INTO v_employee_name;
      EXIT WHEN emp_cursor%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('Employee: ' || v_employee_name);
   END LOOP;
   CLOSE emp_cursor;
END;
/

