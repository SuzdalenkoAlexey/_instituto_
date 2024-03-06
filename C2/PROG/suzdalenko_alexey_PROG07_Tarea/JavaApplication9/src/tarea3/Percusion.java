package tarea3;

public class Percusion extends Instrumento {

    @Override
    public void tocar() {
        System.out.println("Percusion metodo tocar");
    }

    @Override
    public void afinar() {
        System.out.println("Percusion metodo afinar");
       
    }

    @Override
    public void tocar(String nota) {
        System.out.println("Percusion metodo tocar nota="+nota);
    }
    
}
