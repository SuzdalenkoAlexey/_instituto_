package tarea.practica2;
import java.util.Objects;
import java.util.Scanner;
public class Practica2 {
    public static void main(String[] args) {
        String[] questions = {"Una variable es un espacio de almacenamiento en memoria, cuyo contenido puede cambiar a lo largo de la ejecucion del programa (V/F)",
                              "Una estructura iteractiva es aquella que nos permite elegir entre dos o mas opciones (V/F)",
                              "Una estructura selectiva es aquella que nos permite elegir entre dos o mas opciones (V/F)",
                              "Las estructuras while y do-while son equivalienter (V/F)"};
        Boolean[] responses = {true, false, true, false};
        Boolean[] boolArray = new Boolean[4];
        Scanner scanner = new Scanner (System.in);

        for(int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);
            boolArray[i] = scanner.next().toUpperCase().equals("V");
        }
        
        for(int y = 0; y < questions.length; y++){
            String userResponse = (Objects.equals(boolArray[y], responses[y])) ? " ha sido correcta" : " no ha sido correcta";
            System.out.println("La contestacion a la respuesta "+String.valueOf(y)+" "+userResponse);
        }
        scanner.close();
    }
}
