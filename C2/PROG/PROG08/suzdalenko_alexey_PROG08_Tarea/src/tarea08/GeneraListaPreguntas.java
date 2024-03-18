package tarea08;
import java.util.ArrayList;
import java.util.List;

public class GeneraListaPreguntas {
    private List<Pregunta> lista;
    public GeneraListaPreguntas(){
        lista = new ArrayList<>();
        lista.add(new Pregunta('A', "Que depende del azar", "Aleatorio"));
        lista.add(new Pregunta('B', "Que puede tomar solo dos valores", "Boolean"));
        lista.add(new Pregunta('C', "Convertir un tipo de dato a otro", "Cast"));
        lista.add(new Pregunta('D', "Tipo de dato de doble precion", "Double"));
        lista.add(new Pregunta('E', "Tipo de Programacion utilizada antes de la Programacion orientada a objetos", "Estructurada"));
    }
    public List<Pregunta> getLista(){ return lista; }
}
