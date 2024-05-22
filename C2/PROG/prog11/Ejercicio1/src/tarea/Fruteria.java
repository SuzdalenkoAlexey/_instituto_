package tarea;
import java.util.ArrayList;

public class Fruteria {
    private String nombre;
    private String direccion;
    private ArrayList<Fruta> listaFrutas;
    
    public Fruteria(String nombre, String direccion){
        this.nombre      = nombre;
        this.direccion   = direccion;
        this.listaFrutas = new ArrayList<>();
    }
    
    public void agregarFruta(Fruta fruta){
        listaFrutas.add(fruta);
    }
    
    public void eliminarFruta(Fruta fruta){
        for(int i = 0; i < listaFrutas.size(); i++){
            if(this.listaFrutas.get(i).getNombre().equalsIgnoreCase(fruta.getNombre())){
                Fruta eliminada = listaFrutas.remove(i);
                System.out.println("Fruta eliminada: " + eliminada);
            }
        }
    }
    public String representacionTextual(){
        return this.toString();
    }
    public void mostrarFrutas() {
        for (Fruta fruta : listaFrutas) {
            System.out.println(fruta);
        }
    }
}
