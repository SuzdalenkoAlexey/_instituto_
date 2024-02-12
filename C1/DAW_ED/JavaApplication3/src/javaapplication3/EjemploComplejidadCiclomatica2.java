package javaapplication3;
public class EjemploComplejidadCiclomatica2 {
    public static String determinarSigno(int numero) {
        String resultado;

        if (numero > 0) {
            resultado = "Positivo";
        } else if (numero < 0) {
            resultado = "Negativo";
        } else {
            resultado = "Cero";
        }

        return resultado;
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = -3;
        int num3 = 0;

        System.out.println("Número " + num1 + ": " + determinarSigno(num1));
        System.out.println("Número " + num2 + ": " + determinarSigno(num2));
        System.out.println("Número " + num3 + ": " + determinarSigno(num3));
    }
}
/*

    epresentamos el código con un grafo de flujo.
        Nodo 1: Inicio del método
        Nodo 2: Inicialización de la variable resultado
        Nodo 3: Evaluación de numero > 0
        Nodo 4: Asignación si numero > 0
        Nodo 5: Evaluación de numero < 0
        Nodo 6: Asignación si numero < 0
        Nodo 7: Bloque else (si ninguna de las condiciones anteriores es verdadera)
        Nodo 8: Retorno del resultado

    Contar Nodos y Arcos:
        Número de nodos (NN): 8
        Número de arcos (EE): 9

    Calcular Componentes Conexos (PP):
    El grafo es un único componente conectado, por lo que P=1P=1.

    Calcular la Complejidad Ciclomática:
    Utilizando la fórmula M=E−N+2PM=E−N+2P:
    M=9−8+2×1=3M=9−8+2×1=3

Por lo tanto, la complejidad ciclomática para este código es 3. Este valor indica que hay 3 pruebas independientes necesarias para cubrir todas las posibles rutas de ejecución en el método determinarSigno. Recuerda que la complejidad ciclomática es una guía y valores más bajos generalmente se asocian con un código más simple y fácil de entender.
*/