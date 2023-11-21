package tarea.practica3;
import java.util.Scanner;
public class Practica3 {
    public static void main(String[] args) {
        double totalSales = 0;
        double[] priceOfArticles = {239.99, 129.75, 99.95, 350.89};
        
        Scanner scanner = new Scanner (System.in);
        // 200 + (5000 * 9%) = 650
        for(int i = 0; i < priceOfArticles.length; i++){
            String consequence = String.valueOf(i + 1);
            System.out.println("Introduce cuantos elementos del articulo "+consequence+" vendio este vendedor");
            totalSales += priceOfArticles[i] * scanner.nextInt();
        }
        scanner.close();
        
        System.out.println("El total de ventas del sujeto es de "+String.valueOf( totalSales)+ " Euros");
        System.out.println("La comision del sujeto es de "+String.valueOf( totalSales * 9 / 100)+ " Euros");
        System.out.println("El sueldo del sujeto correspondiente a esta semana es de "+String.valueOf( totalSales * 9 / 100 + 200)+ " Euros");
    }
}
