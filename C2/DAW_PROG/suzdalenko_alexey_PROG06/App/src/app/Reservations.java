package app;
import java.util.ArrayList;

public class Reservations {
    private final ArrayList<ArrayList<String>> butacas;
    private final String emptyStr;
    
    public Reservations(){
        this.butacas = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < 20; j++){
              row.add("o");
            }
            this.butacas.add(row);
        }
        this.emptyStr = "                     ";
    }
    
    public void mostrarSala(){
        System.out.println(emptyStr+"----------------------------------------------------------");
        for (int i = 0; i < butacas.size(); i++) {
            String lineaSala = "";
            for (int j = 0; j < butacas.get(i).size(); j++) {
                lineaSala += butacas.get(i).get(j)+"  ";
            }
            System.out.print(emptyStr+lineaSala);
            System.out.println("\n"+emptyStr+"----------------------------------------------------------");
        }
    }
}
