package tarea.practica4;
import java.util.Scanner;
public class Practica4 {
    public static void main(String[] args) {
        String newPass;
        String oldPass;
        Scanner scanner = new Scanner (System.in);
        do{
            System.out.println("Introduce contraseña");
            newPass = scanner.nextLine();
            System.out.println("Introduce de nuevo la contraseña");
            oldPass = scanner.nextLine();
            if(newPass.equals(oldPass)) { 
                System.out.println("Las contraseñas coiciden. Se produce el cambio de contraseña");
                break;
            } else {
                System.out.println("Las contraseñas no coinciden. No se produce el cambio de contraseña.");
            }
        } while(!newPass.equals(oldPass));
        
        scanner.close();
    }
}
