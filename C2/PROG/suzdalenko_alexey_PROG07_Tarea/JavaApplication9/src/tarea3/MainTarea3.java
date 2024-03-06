package tarea3;
import java.util.Random;


public class MainTarea3 {
    public static void main(String[] args) {
        Instrumento[] instrumentos = new Instrumento[10];
        Random random = new Random();
        for (int i = 0; i < instrumentos.length; i++) {
            int tipoInstrumento = random.nextInt(3); 
            switch (tipoInstrumento) {
                case 0 -> instrumentos[i] = new Cuerda();
                case 1 -> instrumentos[i] = new Percusion();
                case 2 -> instrumentos[i] = new Viento();
            }
        }
        for (Instrumento instrumento : instrumentos) {
            instrumento.tocar();
            instrumento.tocar("SOL");
            instrumento.afinar();
            System.out.println("");
        }
    
        /*  ¿Se puede instanciar un objeto de la clase Instrumento?
            por lo general no, aun que si se puede de esta forma (asi no se suele hacer)
            hay sobreescribir los metodos a la vez que se instancia la clase
        */
        Instrumento miInst = new Instrumento() {
            @Override
            public void tocar() {}

            @Override
            public void tocar(String nota) {}

            @Override
            public void afinar() {
                System.out.println("hola, mi metodo afinar ha cambiado");
            }
        };
        miInst.afinar();

        Instrumento miInst2 = new Viento();
        miInst2.tocar();
    

    }
}
