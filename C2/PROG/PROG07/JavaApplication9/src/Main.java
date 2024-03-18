import tarea1.Articulo;
import tarea2.Gato;
import tarea2.Perro;
import tarea2.Mamifero;

public class Main {
    
    public static void muevete(Mamifero m){
        m.mover();
    }

    public static void main(String[] args) {
      
        Articulo articulo = new Articulo();
        articulo.mostrarPrecio();
        articulo.setPrecio();
        articulo.mostrarPrecio();
        articulo.setPrecio(10.0);
        articulo.mostrarPrecio();
        articulo.setPrecio(10.0, 20.0);
        articulo.mostrarPrecio();
        
        Mamifero mami = new Mamifero();
        mami.mover();
        Perro perro = new Perro();
        perro.mover();
        Gato gato = new Gato();
        gato.mover();
        Main.muevete(mami);
        Main.muevete(perro);
        Main.muevete(gato);    
    }
}
