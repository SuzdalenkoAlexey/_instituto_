# TAREA 9 – ADMINISTRACIÓN DE REDES WINDOWS. 

ACTIVIDAD 1. DIAGRAMA DE RED 
La tarea que nos atañe está basada en el diagrama de red adjunto. Realiza tu propia versión del citado diagrama basándote en las diferentes herramientas (tanto de escritorio como online) disponibles en la web. 
Indica la herramienta que has utilizado, realiza alguna captura del proceso de diseño y finalmente incrusta tu diseño final (imagen) en el documento PDF de la tarea. 
Siéntete libre a añadir tus propios iconos y nomenclaturas, descripción de servicios, etiquetas, colores, etc. 
  
NOTA: El cliente Windows puede ser una maquina Windows 10 o cualquiera de las versiones de Windows Server con las que hemos trabajado. Tú decides. 
PREVIAMENTE 
Es importante que tengáis claro como vais a configurar los adaptadores de red en vuestro hipervisor para cada una de las maquinas. 
Por otro lado, en server01: 
	Crea el grupo “instaladores” y el grupo “empresa”. 
	Crea el usuario tu-nick . añádelo al grupo “Administradores” del equipo y luego al grupo “instaladores”. 
	Crea los usuarios mariobros (Mario Bros) y peach (Princesa Peach). Añádelos al grupo “empresa”. 
En cliente01: 
	Crea el usuario donkeykong. Será un usuario “normal”, no lo agregues al grupo “Administradores”. 
NOTA: No es necesario documentar este aparatado. Se entiende que lo sabéis hacer y se confía en que lo hagáis correctamente para el buen desarrollo de la tarea. 
 
 
ACTIVIDAD 2. SERVICIO DHCP 
Configura el servicio DHCP en tu servidor Windows. 
1.	Instala el servicio DHCP en el servidor Windows Server 2022. 
2.	Configura el servicio DHCP con los siguientes parámetros: 
a.	Red 192.168.99.0/24 
b.	Rango de asignaciones del 192.168.9910 al 192.168.99.19. 
c.	Puerta de enlace 192.168.99.1 
d.	Servidor DNS: 8.8.8.8 y 1.1.1.1 
3.	Inicia la máquina Windows cliente y confirma que el servicio DHCP está operativo y funciona correctamente con la configuración definida en el punto 2. 
NOTA: La dirección IP del cliente 192.168.99.x, la “x” se la asignara el servicio DHCP de entre las IPs disponibles. 
 
ACTIVIDAD 3. ENRUTAMIENTO 
Ahora que ya tenemos el servicio DHCP operativo vamos a habilitar el enrutamiento en el servidor Windows para que el cliente tenga internet a través de él. 
1.	Instalar y configurar el servicio de enrutamiento y acceso remoto en server01. 
2.	Confirma que el cliente01 tiene ahora acceso a internet (desde el CMD). 
NOTA: No es necesario documentar la instalación de servicio de enrutamiento. 
 
ACTIVIDAD 4. ESCRITORIO REMOTO 
Ahora que ya tienes configurada la red y los dos equipos pertenecen a ella: 
1.	Conéctate por Escritorio Remoto, desde el cliente01 a la maquina server01 con el usuario tu-nick. 
2.	Copia y pega una carpeta del cliente01 al escritorio del server01. 
3.	“Mapea” las unidades locales (del cliente01) al server01. Confirma que puedes navegar por ellas. 
4.	Prueba ahora a conectarte con la Princesa Peach. ¿Puedes conectarte? ¿Por qué? 





 	 
ACTIVIDAD 5. COMPARTIR CARPETAS 
Añade un segundo disco (1GB es suficiente) al server01. Formatea como NTFS y asigna la letra “X:”. Crea en la una carpeta denominada COMPARTE y dentro de ellas las carpetas software y tu-nick. Copia o crea ficheros y carpetas dentro de ellas para que tengan contenido. 
NOTA: No es necesario documentar el paso anterior. 
Realizar todo lo necesario para que: 
1.	Comparte la carpeta tu-nick de tal forma que: 
o    El grupo instaladores puedan crear/modificar/eliminar archivos y subcarpetas. 
o	El grupo empresa solo tenga acceso de lectura. 
2.	Comparte la carpeta software de tal forma que: 
o	El grupo empresa pueda crear/modificar/eliminar archivos y subcarpetas. 
3.	Además de compartir, ¿has modificado los permisos NTFS de las carpetas? ¿Por qué? 
4.	Logueate con el usuario donkeykong en cliente01 y accede a las carpetas compartidas software y tunick simulando que formas parte del grupo “empresa” (es decir, sabes que existe un usuario denominado mariobros y también conoces su contraseña). 
5.	Mapea, en cliente01, la carpeta software asignando la letra S: 
6.	Mapea, en cliente01, la carpeta tu-nick asignando la letra Z: 
7.	Justifica que funcionan los permisos. 
8.	¿Desde cliente01 existe alguna forma de acceder a “C:” en server01? ¿y a “X: ”.... Aquí tienes una pista: el símbolo $ 
 	  
RECURSOS 
Herramientas para crear diagramas de red
 	https://www.redeszone.net/tutoriales/redes-cable/herramientas-crear-diagramas-redes/ 
Diagramas online 
https://www.drawio.com/ 
Como configurar un servidor DHCP en Windows Server 2022 https://tutorialesit.com/como_configurar_servidor_dhcp_windows_server_2022/ 
 
Apuntes de la plataforma. 
CRITERIOS DE CORRECCIÓN 

Actividad 1. 1 puntos. 
Actividad 2. 2 puntos 
Actividad 3: 2 puntos 
Actividad 4: 2 puntos. 
Actividad 5: 3 puntos 
 
RECORDAD QUE LAS ENTREGAS QUE NO CUMPLAN CON EL FORMATO EXIGIDO DE “ENTEGA DE TAREAS” SERAN PENALIZADAS. 
CAPTURA LAS PANTALLAS que JUSTIFIQUEN lo solicitado COMENTA las CAPTURAS de PANTALLA
IDENTIFICATE EN TODAS LAS CAPTURAS
 
Fecha fin entrega: 12 de abril de 2024 
