package tarea3;

public class Viento extends Instrumento {

    @Override
    public void tocar() {
        System.out.println("Viento metodo tocar");
    }

    @Override
    public void afinar() {
        System.out.println("Viento metodo afinar");
    }

    @Override
    public void tocar(String nota) {
        System.out.println("Viento metodo tocar nota="+nota);
    }
    
}
