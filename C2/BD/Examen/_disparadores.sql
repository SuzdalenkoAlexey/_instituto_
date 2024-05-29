-- Ejemplo 1: Disparador BEFORE INSERT
CREATE OR REPLACE TRIGGER before_insert_employee
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
   :NEW.employee_name := UPPER(:NEW.employee_name);
END;
/

-- Ejemplo 2: Disparador AFTER UPDATE
CREATE OR REPLACE TRIGGER after_update_employee
AFTER UPDATE ON employees
FOR EACH ROW
BEGIN
   INSERT INTO employees_audit (employee_id, old_salary, new_salary, update_date)
   VALUES (:OLD.employee_id, :OLD.salary, :NEW.salary, SYSDATE);
END;
/

-- Ejemplo 3: Disparador BEFORE DELETE
CREATE OR REPLACE TRIGGER before_delete_employee
BEFORE DELETE ON employees
FOR EACH ROW
BEGIN
   IF :OLD.role = 'MANAGER' THEN
      RAISE_APPLICATION_ERROR(-20001, 'No se puede eliminar a los empleados con rol de MANAGER.');
   END IF;
END;
/

-- Ejemplo 4: Disparador AFTER INSERT OR UPDATE OR DELETE
CREATE OR REPLACE TRIGGER after_dml_employee
AFTER INSERT OR UPDATE OR DELETE ON employees
BEGIN
   DECLARE
      v_total_employees NUMBER;
   BEGIN
      SELECT COUNT(*)
      INTO v_total_employees
      FROM employees;

      UPDATE employees_summary
      SET total_employees = v_total_employees;
   END;
END;
/

-- Ejemplo 5: Disparador para manejar el historial de salarios
CREATE OR REPLACE TRIGGER update_salary_history
AFTER UPDATE OF salary ON employees
FOR EACH ROW
BEGIN
   INSERT INTO salary_history (employee_id, old_salary, new_salary, change_date)
   VALUES (:OLD.employee_id, :OLD.salary, :NEW.salary, SYSDATE);
END;
/
