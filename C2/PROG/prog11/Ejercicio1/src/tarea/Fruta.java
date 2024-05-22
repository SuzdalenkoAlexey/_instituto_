package tarea;

public class Fruta {
    private String nombre;
    private Double precio;
    private String descripcion;
    public Fruta(String nombre, Double precio, String descripcion){
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    public String representacionTextual(){
        return this.toString();
    }
    public String getNombre(){
        return this.nombre;
    }
    public Double getPrecio(){
        return this.precio;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
}
