package javaapplication3;
public class EjemploComplejidadCiclomatica3 {
     public static String determinarCategoria(int edad) {
        String categoria;

        if (edad < 12) {
            categoria = "Niño";
        } else if (edad < 18) {
            categoria = "Adolescente";
        } else {
            categoria = "Adulto";
        }

        return categoria;
    }

    public static void main(String[] args) {
        int edad1 = 8;
        int edad2 = 15;
        int edad3 = 25;

        System.out.println("Edad " + edad1 + ": " + determinarCategoria(edad1));
        System.out.println("Edad " + edad2 + ": " + determinarCategoria(edad2));
        System.out.println("Edad " + edad3 + ": " + determinarCategoria(edad3));
    }
}
/*Ahora, expliquemos los conceptos de nodo, arco y grafo:

    Nodo:
        En el contexto de complejidad ciclomática, un nodo representa una instrucción o punto de decisión en el código fuente. Cada nodo es una entidad en el flujo de control del programa.
        En el ejemplo, los nodos serían las líneas de código que inician con if, else if y else.

    Arco:
        Un arco conecta dos nodos y representa una transición de control entre ellos. En otras palabras, un arco indica la dirección en la que se ejecutará el programa.
        En el ejemplo, los arcos conectarían los nodos correspondientes a las diferentes condiciones if y else.

    Grafo:
        Un grafo en este contexto es una representación visual de la estructura de control de un programa. En el caso de complejidad ciclomática, se trata de un grafo dirigido que muestra cómo el flujo de control se mueve a través del código.
        En el ejemplo, el grafo incluiría nodos para las condiciones if y else junto con arcos que indican la dirección del flujo de control.

La complejidad ciclomática se calcula mediante la fórmula M=E−N+2PM=E−N+2P, donde:

    MM es la complejidad ciclomática.
    EE es el número de arcos en el grafo.
    NN es el número de nodos en el grafo.
    PP es el número de componentes conexos.

En resumen, en el contexto de la complejidad ciclomática, un grafo representa la estructura de control del programa, los nodos son las decisiones o puntos de ejecución, y los arcos son las transiciones entre estas decisiones. El cálculo de la complejidad ciclomática proporciona información sobre la complejidad y la cantidad de pruebas necesarias para cubrir todas las rutas posibles en el código.
*/