package tarea1;

public class Articulo {
    private double precio;
    
    public Articulo(){}
    
    public void setPrecio(){
        precio = 3.5;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public void setPrecio(double precio, double porcentaje){
        this.precio = precio + (precio * porcentaje / 100);
    }
    
    public void mostrarPrecio(){
        System.out.println("Precio "+String.valueOf(precio));
    }
}
