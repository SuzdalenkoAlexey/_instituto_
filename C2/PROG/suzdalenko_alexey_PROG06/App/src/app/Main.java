package app;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
       Legends legends = new Legends();           
       Reservations reservations = new Reservations();
       Scanner scanner = new Scanner(System.in); 
       int number;
       
       legends.inicioApp();
       
       do{
           number = scanner.nextInt();
           switch(number){
               case 1 -> legends.mostrar();
               case 2 -> reservations.mostrarSala();
               case 3 -> {
                   int[] entradaNueva = reservations.comprarEntrada(scanner);
                   if(entradaNueva != null){ reservations.imprimirEntrada(entradaNueva); }
                   legends.inicioApp();
               }
               case 4 -> {
                   reservations.devolverEntrada(scanner);
                   legends.inicioApp();
               }
               case 5 -> {
                   reservations.mostrarRecaudacion();
                   legends.inicioApp();
               }
           }
       } while(number != 0);
       
       
       
       
    }
    
}
