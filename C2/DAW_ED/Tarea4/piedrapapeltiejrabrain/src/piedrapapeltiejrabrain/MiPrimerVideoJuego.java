/**
 * Copyright (c) [2024] [Alexey Suzdalenko]
 * Permiso otorgado, sin cargo, a cualquier persona que obtenga una copia
 * de este software y los archivos de documentación asociados (el "Software").
 * El aviso de copyright anterior y este aviso de permisos se incluirán en
 * todas las copias o partes sustanciales del Software.
 * EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTIA DE NINGÚN TIPO, EXPRESA
 * O IMPLICITA.
 */
package piedrapapeltiejrabrain;
import java.util.Scanner;
/**
 * Clase principal que implementa un juego de piedra, papel o tijera 
 * entre la aplicacion java - mas adelante bot y
 * el jugador humano - mas adelante jugador,
 * que intenta ganar o perder según el propósito del juego. 
 * 
 * @version 1.0
 * @author Alexey Suzdalenko
 * @since 11/02/2024
 * 
 */
public class MiPrimerVideoJuego {
    /**
     * Método principal que inicia el juego y gestiona la lógica del juego.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        int chiquipuntos = 0;                       // puntuacion del jugador 
        Scanner sc = new Scanner(System.in);  // objeto scanner para entrada jugador
        String opcionJugador = "";                  // opcion elegida por el jugador
        String opcionBot = "";                      // opcion elegida por el bort
        int exitoEnProposito = 1;                   // exito o fracaso segun el proposito
        long inicio = System.currentTimeMillis();   // registro del tiempo al inciar el juego
        // Ciclo principal del juego - 5 vueltas
        for (int i = 0; i < 5; i++) {
            int proposito = (int) Math.floor(Math.random() * 2 + 1); // proposito del juego aleatorio ganar(1) o perder(2
            // 
            if (proposito == 1) {
                System.out.println("\n\tIntenta ganar");
            }
            if (proposito == 2) {
                System.out.println("\n\tIntenta perder");
            }
            int j = (int) Math.floor(Math.random() * 3 + 1);

            if (j == 1) {
                opcionBot = "tijera";
                System.out.println(opcionBot);
                tijera();

            }
            if (j == 2) {
                opcionBot = "papel";
                System.out.println(opcionBot);
                papel();
            }
            if (j == 3) {
                opcionBot = "piedra";
                System.out.println(opcionBot);
                piedra();

            }
            // Solicitar la jugada del jugador y validar que no sea un empate
            do {
                System.out.println("Introduce tu jugada");
                opcionJugador = sc.nextLine();
                if (opcionBot.equals(opcionJugador)) {
                    System.out.println("No tiene sentido que intentes empatar");
                }

            } while (opcionBot.equals(opcionJugador));
            if (opcionJugador.equals("tijera") && (opcionBot.equals("papel"))) {
                exitoEnProposito = 1;

            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = -1;

            }
            if (opcionJugador.equals("tijera") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = -1;

            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = 1;
            }

            if (opcionJugador.equals("piedra") && (opcionBot.equals("papel"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = 1;
            }
            if (proposito == 2) {
                exitoEnProposito *= -1;

            }
            if (exitoEnProposito == 1) {
                chiquipuntos++;
            }
        }
        long fin = System.currentTimeMillis();

        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");
        int nFallos = 5 - chiquipuntos;
        System.out.println("Penalización: " + nFallos + "*5s="+nFallos*5);
        double tiempoFinal = tiempo + nFallos * 5;
        System.out.println("Tu tiempo final es de "+tiempoFinal+" segundos"); 
    }
    /**
     * Método que imprime una representación visual de la opción "tijera".
     * Cuando la aplicacion(bot) saca tijera j == 1
     */
    public static void tijera() {
        System.out.println("'''\n"
                + "    _______\n"
                + "---'   ____)____\n"
                + "          ______)\n"
                + "       __________)\n"
                + "      (____)\n"
                + "---.__(___)\n"
                + "'''");
    }
    /**
     * Método que imprime una representación visual de la opción "papel".
     * Cuando la aplicacion(bot) saca papel j == 2
     */
    public static void papel() {
        System.out.println("'''\n"
                + "     _______\n"
                + "---'    ____)____\n"
                + "           ______)\n"
                + "          _______)\n"
                + "         _______)\n"
                + "---.__________)");
    }
    /**
     * Método que imprime una representación visual de la opción "piedra".
     * Cuando la aplicacion(bot) saca piedra j == 3
     */
    public static void piedra() {
        System.out.println("'''\n"
                + "    _______\n"
                + "---'   ____)\n"
                + "      (_____)\n"
                + "      (_____)\n"
                + "      (____)\n"
                + "---.__(___)\n"
                + "'''");
    }
    /*
    one comment
    one comment
    one comment
    one comment
    */
}
