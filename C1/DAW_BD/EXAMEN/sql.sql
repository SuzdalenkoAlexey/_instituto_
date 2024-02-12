select nombre,ape1,salario from empleado where salario > 1000 order by 2;

select nombre,ape1,comision, salario from empleado where comision > salario * 0.2;

select coddpto,codemple,nombre,ape1,(salario+nvl(comision,0))*166.386
from empleado where salario+nvl(comision,0)>1800
order by coddpto,nombre,ape1;
    NVL reemplazar valores nulos (NULL) 

select nombre, ape1, salario from empleado
where salario >= (select salario * 1.05 from empleado where ape1='JAZMIN' and nombre='MARIA') order by 2;

SELECT nombre,ape1,ape2, (sysdate-fechaingreso)/365.20 as "Antigüedad" from empleado order by 3;

select ape1,nombre from empleado where coddpto= some(select coddpto from dpto where presupuesto>50000)
    SOME una subconsulta cumple con una condición específica

select ape1,nombre, nvl(comision,0)+salario from empleado where nvl(comision,0)+salario >= all (select nvl(comision,0)+salario from empleado);
    ALL para evaluar si todos los resultados de una subconsulta cumplen con una condición específica

select nombre,ape1,salario from empleado where salario < all (select salario from empleado where coddpto=1)