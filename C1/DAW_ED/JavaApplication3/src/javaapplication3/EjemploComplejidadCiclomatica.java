
package javaapplication3;

public class EjemploComplejidadCiclomatica {
    public static int sumaParesEnRango(int inicio, int fin) {
        int suma = 0;

        for (int i = inicio; i <= fin; i++) {
            if (i % 2 == 0) {
                suma += i;
            } else {
                // Hacemos algo diferente si el número es impar
                System.out.println("Número impar: " + i);
            }
        }

        return suma;
    }

    public static void main(String[] args) {
        int resultado = sumaParesEnRango(1, 10);
        System.out.println("Suma de pares: " + resultado);
    }
}
/*



Ahora, vamos a calcular la complejidad ciclomática para este código.

    Dibujo del Grafo de Flujo:
    Puedes representar el código con un grafo de flujo. Cada nodo representa una instrucción y cada arco representa una transición entre instrucciones.
        Nodo 1: Inicio del método
        Nodo 2: Inicialización de la variable suma
        Nodo 3: Inicio del bucle for
        Nodo 4: Verificación del número par
        Nodo 5: Suma del número par
        Nodo 6: Bloque else (número impar)
        Nodo 7: Fin del bucle for
        Nodo 8: Retorno del resultado

    El grafo tendría arcos conectando estos nodos de acuerdo con el flujo del programa.

    Contar Nodos y Arcos:
        Número de nodos (NN): 8
        Número de arcos (EE): 10

    Calcular Componentes Conexos (PP):
    En este caso, el grafo es un único componente conectado, por lo que P=1P=1.

    Calcular la Complejidad Ciclomática:
    Utilizando la fórmula M=E−N+2PM=E−N+2P:
    M=10−8+2×1=4M=10−8+2×1=4

Entonces, la complejidad ciclomática para este código es 4. Este valor indica que habría 4 pruebas independientes necesarias para cubrir todas las posibles rutas de ejecución en el método sumaParesEnRango. Recuerda que, en general, se considera que valores más bajos de complejidad ciclomática son preferibles, ya que indican un código más simple y fácil de entender
*/