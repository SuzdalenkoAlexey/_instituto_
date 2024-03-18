package tarea3;

public class Cuerda extends Instrumento {

    @Override
    public void tocar() {
        System.out.println("Cuerda metodo tocar");
    }

    @Override
    public void afinar() {
        System.out.println("Cuerda metodo afinar");
    }

    @Override
    public void tocar(String nota) {
        System.out.println("Cuerda metodo tocar nota="+nota);
    }
    
}
