
package ejecicios.Ejercicio1;

public class Main {

    public static void main(String[] args) {
        
        Puerta  p1 = new Puerta();
        
        System.out.println("La pueta mide "+p1.GetAncho()+"m de ancho, "+p1.GetLargo()+"m de largo y esta "+ p1.mostrarEstado());
        
        p1.Abrir();
        
        System.out.println("La pueta mide "+p1.GetAncho()+"m de ancho, "+p1.GetLargo()+"m de largo y esta "+ p1.mostrarEstado());
   
    }
    
}
