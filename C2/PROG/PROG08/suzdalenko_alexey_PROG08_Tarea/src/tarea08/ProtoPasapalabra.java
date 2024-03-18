package tarea08;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProtoPasapalabra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GeneraListaPreguntas glp = new GeneraListaPreguntas();
        
        
        /* PREGUNTAMOS AL JUGADOR */
        for(Pregunta p: glp.getLista()){
            System.out.println("-----------------------------"+p.getIdentificador()+"-----------------------------");
            System.out.println(p.getEnunciado());
            String respuestaUsuario = scanner.nextLine().trim();
            if(respuestaUsuario.equalsIgnoreCase(p.getRespuesta())){
                /* respuesta correcta VERDE */
                p.cambiaRespuestaCorrecta();
            } else if(respuestaUsuario.equalsIgnoreCase("Pasapalabra")){
                /* color AZUL pasapalabra  */
                p.cambiaPasapalabra();
            } else {
                /* respuesta incorrecta ROJO */
                p.cambiaRespuestaIncorrecta();
            }
        }
        
        /* MOSTRAMOS RESPUESTAS JUGADOR */
        System.out.println("-----------------------------------------");
        System.out.println("Mostramos el estado actual del \"rosco\" ");
        System.out.println("-----------------------------------------");
        
        for(Pregunta p: glp.getLista()){
            System.out.println("-----------------------------"+p.getIdentificador()+"-----------------------------");
            System.out.println(p.getEnunciado());
            System.out.println(p.getRespuesta_correcta());
        }
    }
}
