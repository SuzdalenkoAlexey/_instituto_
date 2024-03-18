package app;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservations {
    private  ArrayList<ArrayList<String>> butacas;
    private final String emptyStr;
    private int recaudacion;
    
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
        this.recaudacion = 0;
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
    
    public int[] comprarEntrada(Scanner scanner){
        int[] res = {0, 0};
        System.out.println("Por favor, introduzca el numero de fila y el numero de butaca que quiere");
        int numeroFila   = scanner.nextInt();
        int numeroButaca = scanner.nextInt();
        System.out.println("La entrada cuesta 3 Euros. Esta de acuerdo (S/N)");
        String estaDeAcuerdo = scanner.next().toLowerCase();
        
        if(estaDeAcuerdo.equals("s")){
            String estadoActual = butacas.get(numeroFila - 1).get(numeroButaca-1);
            if(estadoActual.equals("X")){
                System.out.println("Transaccion no puede realizarse porque la entrada ya esta vendida");
                return null;
            } else {
                recaudacion += 3;
                butacas.get(numeroFila - 1).set(numeroButaca - 1, "X");
                res[0] = numeroFila - 1; 
                res[1] = numeroButaca - 1;
                return res;
            }
        } else {
            return null;
        }
       
    }
    
    public void imprimirEntrada(int[] res){
          System.out.println("           IMPRIMIENDO ENTRADA");
          System.out.println("           -----------------------");
          System.out.println("           ***********************************************************");
          System.out.println("           * Festival Only Ships                     Sala: Nostromo  *");
          System.out.println(  "           * Fila: "+res[0]+" Butaca: "+res[1]+"                       Precio: 3€      *");
          System.out.println("           ***********************************************************");
          System.out.println("           -----------------------");
    }
    
    public void devolverEntrada(Scanner scanner){
        System.out.println("Por favor, introduzca el numero de fila y el numero de butaca que quiere devolver");
        int numeroFila   = scanner.nextInt();
        int numeroButaca = scanner.nextInt();
        System.out.println("Se devolveran 3 Euros. Esta de acuerdo (S/N)");
        String estaDeAcuerdo = scanner.next().toLowerCase();
        if(estaDeAcuerdo.equals("s")){
            if(butacas.get(numeroFila - 1).get(numeroButaca - 1).equals("o")){
                System.out.println("Trasaccion no puede realizarse porque la entrada no habia sido vendida");
            } else {
                butacas.get(numeroFila - 1).set(numeroButaca - 1, "o");
                recaudacion -= 3;
            }
        } 
    }
    
    public void mostrarRecaudacion(){
        System.out.println("La recaudaciones es "+recaudacion+" Euros.");
    }
}
