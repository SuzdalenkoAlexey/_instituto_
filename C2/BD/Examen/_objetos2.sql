-- Tipo de Objeto Address
CREATE OR REPLACE TYPE Address AS OBJECT (
   street VARCHAR2(50),
   city VARCHAR2(50),
   state VARCHAR2(50),
   zip_code VARCHAR2(10)
);
/
-- Tipo de Objeto Employee
CREATE OR REPLACE TYPE Employee AS OBJECT (
   employee_id NUMBER,
   employee_name VARCHAR2(100),
   salary NUMBER,
   address Address, -- Uso del objeto Address
   MEMBER FUNCTION get_annual_salary RETURN NUMBER,
   MEMBER PROCEDURE give_raise(p_percentage IN NUMBER)
);
/

-- Ahora, definimos los métodos del tipo de objeto Employee.
CREATE OR REPLACE TYPE BODY Employee IS
   MEMBER FUNCTION get_annual_salary RETURN NUMBER IS
   BEGIN
      RETURN salary * 12;
   END get_annual_salary;

   MEMBER PROCEDURE give_raise(p_percentage IN NUMBER) IS
   BEGIN
      salary := salary * (1 + p_percentage / 100);
   END give_raise;
END;
/

-- Creamos una tabla que puede almacenar instancias del tipo de objeto Employee.
CREATE TABLE employees_table OF Employee;

-- Paso 4: Insertar Datos en la Tabla de Objetos
INSERT INTO employees_table VALUES (
   Employee(1, 'John Doe', 3000, Address('123 Main St', 'Springfield', 'IL', '62701'))
);
INSERT INTO employees_table VALUES (
   Employee(2, 'Jane Smith', 4000, Address('456 Oak St', 'Springfield', 'IL', '62701'))
);

-- Paso 5: Usar Métodos de Objetos y Manipulación
DECLARE
   v_employee Employee;
   v_annual_salary NUMBER;
BEGIN
   -- Seleccionar un empleado específico
   SELECT VALUE(e) INTO v_employee
   FROM employees_table e
   WHERE e.employee_id = 1;
   
   -- Usar el método get_annual_salary
   v_annual_salary := v_employee.get_annual_salary;
   DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_annual_salary);
   
   -- Dar un aumento al empleado
   v_employee.give_raise(10);
   
   -- Mostrar el nuevo salario
   DBMS_OUTPUT.PUT_LINE('New Salary: ' || v_employee.salary);
   
   -- Acceder a la dirección del empleado
   DBMS_OUTPUT.PUT_LINE('Address: ' || v_employee.address.street || ', ' || v_employee.address.city || ', ' || v_employee.address.state || ' ' || v_employee.address.zip_code);
   
   -- Actualizar la tabla con el nuevo salario
   UPDATE employees_table e
   SET e = v_employee
   WHERE e.employee_id = 1;
END;
/
