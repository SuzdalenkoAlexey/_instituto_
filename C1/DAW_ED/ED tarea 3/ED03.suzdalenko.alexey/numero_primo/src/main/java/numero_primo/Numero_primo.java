package numero_primo;
import java.util.Scanner;
public class Numero_primo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        String resultado = (primo(numero)) ? "El numero es primo": "El numero no es primo";
        System.out.println(resultado);
    }
    
    public static boolean primo(int numero){
        boolean cierto = true; 
        for(int i = 2; i < numero; i++){
            if(numero % i == 0){
                cierto = false;
            }
        }
        return cierto;
    }
}
