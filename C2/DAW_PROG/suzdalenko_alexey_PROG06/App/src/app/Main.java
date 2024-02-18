package app;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
       Legends legends = new Legends();           
       Reservations reservations = new Reservations();
       Scanner scanner = new Scanner(System.in); 
       int number;
       
       System.out.println(legends.festival);
       System.out.println(legends.menu);
       
       do{
           number = scanner.nextInt();
           switch(number){
               case 1 -> legends.mostrar();
               case 2 -> reservations.mostrarSala();
           }
       } while(number != 0);
       
       
       
       
    }
    
}
