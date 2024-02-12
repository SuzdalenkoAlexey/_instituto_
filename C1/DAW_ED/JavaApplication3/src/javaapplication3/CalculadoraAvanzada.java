package javaapplication3;

public class CalculadoraAvanzada {
    // Método que realiza operaciones matemáticas básicas
    public static double calcular(double a, double b, String operacion) {
        switch (operacion) {
            case "suma":
                return a + b;
            case "resta":
                return a - b;
            case "multiplicacion":
                return a * b;
            case "division":
                if (b != 0) {
                    return a / b;
                } else {
                    throw new IllegalArgumentException("No se puede dividir por cero");
                }
            default:
                throw new IllegalArgumentException("Operación no válida");
        }
    }

    public static void main(String[] args) {
        // Pruebas de caja negra
        System.out.println("Caso de prueba básico suma: " + (calcular(2, 3, "suma") == 5));
        System.out.println("Caso de prueba básico resta: " + (calcular(5, 2, "resta") == 3));
        System.out.println("Caso de prueba básico multiplicacion: " + (calcular(4, 2, "multiplicacion") == 8));

        // Caso de prueba límite inferior división
        try {
            System.out.println("Caso de prueba límite inferior división: " + (calcular(1, 0, "division") == Double.POSITIVE_INFINITY));
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }

        // Caso de prueba límite superior multiplicación
        System.out.println("Caso de prueba límite superior multiplicacion: " + (calcular(Double.MAX_VALUE, 2, "multiplicacion") == Double.POSITIVE_INFINITY));

        // Caso de prueba valores extremos
        System.out.println("Caso de prueba valores extremos: " + (calcular(Double.MIN_VALUE, Double.MAX_VALUE, "suma") == Double.MIN_VALUE + Double.MAX_VALUE));

        // Manejo de situaciones inesperadas
        try {
            // Intentamos realizar una operación no válida
            System.out.println("Caso de prueba operación no válida: " + (calcular(1, 2, "potencia") == 3));
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }
    }
}

/*
 * 
 * En este ejemplo, la clase CalculadoraAvanzada tiene un método calcular que realiza operaciones matemáticas básicas. Hemos incluido pruebas de caja negra para casos básicos, límites inferiores y superiores, valores extremos y situaciones inesperadas.

Ahora, para calcular la complejidad ciclomática, podemos construir un grafo de flujo del programa. En este caso, hay múltiples caminos debido a la estructura del switch. Puedes utilizar la fórmula M=E−N+2PM=E−N+2P como se explicó anteriormente para calcular la complejidad ciclomática. Countamos el número de nodos (NN), arcos (EE), y componentes conexos (PP) en el grafo de flujo.

En este caso, el cálculo específico puede variar dependiendo de cómo defines los nodos y los arcos. En general, contar las estructuras de control (como bucles o condicionales) y sumar 1 al resultado es un enfoque común. En este caso, supongamos que el grafo tiene N=8N=8 nodos y E=10E=10 arcos. No hay componentes desconectados (P=0P=0).

M=10−8+2×0=2M=10−8+2×0=2

Por lo tanto, la complejidad ciclomática es 2. Este número indica que hay 2 caminos lineales independientes a través del programa, y se podría argumentar que necesitarías al menos 2 pruebas para cubrir todas las posibilidades.
 * 
 * 
 */
