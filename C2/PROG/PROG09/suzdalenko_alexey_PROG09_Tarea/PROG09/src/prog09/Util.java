package prog09;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class Util {
    public static int id = 1;
    private ArrayList<String> options;
    
    public Util(){
        options = new ArrayList<>();
        options.add("1-Mostrar stock");
        options.add("2-Quitar producto");
        options.add("3-Introducir producto en stock");
        options.add("4-Guardar stock actual en archivo");
        options.add("5-Salir");
    }
    
    public void showMenu(){
        for(String item: options){
             System.out.println(item);
        }
    }
        
    public void saveLinkedListToTxt(LinkedList<Producto> linkedList){
         try {
            FileWriter writer = new FileWriter("src/prog09/productos.txt");
            for (Producto item : linkedList) {
                writer.write("La categoria del producto es "+item.getTipoProducto()+" Su titulo es: "+item.getTitulo()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public void readTxt(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/prog09/productos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public void showStock(LinkedList<Producto> linkedList){
        int number = 1;
        for (Producto item : linkedList) {
            // System.out.println(number++ +" "+item.getTipoProducto()+":"+item.getTitulo());
            System.out.println(item.getId()+" "+item.getTipoProducto()+":"+item.getTitulo());
        }
    }
    
    public void deleteById(LinkedList<Producto> linkedList, int deleteId){
         for (int i = 0; i < linkedList.size(); i++) {
            Producto p = linkedList.get(i);
            if (p.getId() == deleteId) {
                String message = "Has vendido un "+p.getTipoProducto();
                linkedList.remove(i);
                this.saveLinkedListToTxt(linkedList);
                System.out.println(message);
            }
        }
    }
    
    public void addNewItem(LinkedList<Producto> linkedList, Producto p){
        linkedList.add(p);
    }
    
    public int inInt(){
        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        return in;
    }
    
    public String inStr(){
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        return in;
    }
}
