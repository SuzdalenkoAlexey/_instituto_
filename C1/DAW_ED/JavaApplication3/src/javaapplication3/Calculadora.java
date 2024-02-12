package javaapplication3;

public class Calculadora {
    // Método que suma dos números
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);

        // Casos de prueba básicos
        System.out.println("Caso de prueba básico 1: " + (sumar(2, 3) == 5));
        System.out.println("Caso de prueba básico 2: " + (sumar(-5, 8) == 3));
        // Z:\Laboratorio\ANALISIS MICRO_2023.xlsx
        // Límites inferiores y superiores
        System.out.println("Caso de prueba límite inferior: " + (sumar(Integer.MIN_VALUE, -1) == Integer.MIN_VALUE - 1));
        System.out.println("Caso de prueba límite superior: " + (sumar(Integer.MAX_VALUE, 1) == Integer.MAX_VALUE));
        
        System.out.println("CUANTO VA A SER ESTA SUMA "+sumar(Integer.MAX_VALUE, 0));
        System.out.println("CUANTO VA A SER ESTA SUMA "+sumar(Integer.MAX_VALUE, 1));
        System.out.println("CUANTO VA A SER ESTA SUMA "+sumar(Integer.MAX_VALUE, -1));

        // Valores extremos
        System.out.println("Caso de prueba valores extremos: " + (sumar(0, Integer.MAX_VALUE) == Integer.MAX_VALUE));

        // Manejo de situaciones inesperadas
        try {
            // Intentamos sumar dos números grandes para provocar un desbordamiento
            System.out.println("Caso de prueba desbordamiento: " + (sumar(Integer.MAX_VALUE, 10) == Integer.MAX_VALUE));
        } catch (ArithmeticException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }
    }
    /*
     * Este ejemplo incluye casos de prueba básicos, límites inferiores y superiores, y valores extremos. Además, muestra cómo manejar situaciones inesperadas, como el desbordamiento aritmético al sumar números grandes. Ten en cuenta que las pruebas pueden variar según la funcionalidad específica que estés evaluando.
     * 
     * 
     * 
     * a complejidad ciclomática es una métrica que se utiliza para medir la complejidad de un programa mediante la cantidad de caminos lineales independientes a través de su código fuente. La fórmula básica para calcular la complejidad ciclomática es:

M=E−N+2PM=E−N+2P

Donde:

    MM es la complejidad ciclomática.
    EE es el número de arcos en el grafo de flujo del programa.
    NN es el número de nodos en el grafo de flujo del programa.
    PP es el número de componentes conexos (porciones del código que están desconectadas del resto del programa).

Primero, vamos a construir el grafo de flujo del programa para el método sumar en el ejemplo proporcionado. En este caso, el grafo será bastante simple ya que solo hay una ruta de ejecución básica.

Grafo de flujo del programa para sumar:

Inicio
 |
 V
Sumar(a, b)
 |
 V
Retornar resultado
 |
 V
Fin

En este grafo, hay 3 nodos (N=3N=3) y 2 arcos (E=2E=2). No hay componentes desconectados (P=0P=0). Ahora podemos calcular la complejidad ciclomática usando la fórmula:

M=E−N+2P=2−3+2×0=−1M=E−N+2P=2−3+2×0=−1

La complejidad ciclomática resultante es -1. La complejidad ciclomática generalmente se interpreta como el número mínimo de pruebas necesarias para cubrir todos los caminos del programa. En este caso, la complejidad ciclomática negativa sugiere que el código es demasiado simple para ser medido de manera significativa con esta métrica. En programas más complejos, la complejidad ciclomática se utiliza como una guía para la cantidad de pruebas que se deben realizar para garantizar una cobertura completa del código.


     */
}
