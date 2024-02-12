package ejecicios.Ejercicio2;

public class Main {

    public static void main(String[] args) {
        Tarea t = new Tarea();
        
        t.aumentarPrioridad();t.aumentarPrioridad();t.aumentarPrioridad();
        t.aumentarPrioridad();t.aumentarPrioridad();t.aumentarPrioridad();
        System.out.println("La prioridad es "+t.getPrioridad());
        
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        t.aumentarPrioridad();
        System.out.println("La prioridad es "+t.getPrioridad());
        
        t.setDesciption("es Tarea Nueva");
        
        System.out.println("La descripcion de la tarea es: "+t.getDescription());
    }
}
