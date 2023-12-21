package com.mycompany.proyectopotencia;
import java.util.Scanner;
public class ProyectoPotencia {

      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base      =  sc.nextInt();
        int exponente =  sc.nextInt();
        
        System.out.println(base+" "+exponente+" "+Math.pow(base, exponente));
        System.out.println(base+" "+exponente+" "+potenciaIteractiva(base, exponente));
        System.out.println(base+" "+exponente+" "+potenciaRecursiva(base, exponente));
    }
    
    public static double potenciaIteractiva(int x, int y){
        int resultado = 1;
        for(int i = 0; i < y; i++){
            resultado = resultado * x;
        }
        return resultado;
    }
    
    public static double potenciaRecursiva(int x, int y){
        if(y == 0) return 1;
        else {
            return x * potenciaRecursiva(x, y - 1);
        }
    }
    
}
