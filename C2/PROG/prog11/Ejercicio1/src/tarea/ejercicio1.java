package tarea;
public class ejercicio1 {

    public static void main(String[] args) {
        Fruteria miFruteria = new Fruteria("Fruteria Suzdal", "Santader");
        Fruta manzana = new Fruta("Manzana", 1.1, "Manzana roja");
        miFruteria.agregarFruta(manzana);
        Fruta pera = new Fruta("Pera", 1.2, "Pera roja");
        miFruteria.agregarFruta(pera);
        Fruta coco = new Fruta("Coco", 1.3, "Coco");
        miFruteria.agregarFruta(coco);
        
        miFruteria.mostrarFrutas();
    }
    
}
