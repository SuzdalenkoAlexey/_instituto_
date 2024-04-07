package prog09;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        int inValue;
        LinkedList<Producto> linkedList = new LinkedList();
        Comic comic = new Comic("Conan el Bárbaro 35 Aniversario", Util.id++, null, null);
        linkedList.add(comic);
        Libro libro = new Libro("Las Montañas de la Locura", Util.id++, null);
        linkedList.add(libro);
        
        /* guardo linkedList en txt */
        util.saveLinkedListToTxt(linkedList);
        /* mustro el menu */
        util.showMenu();    
        
        while((inValue = util.inInt()) != 5){
            switch (inValue) {
                case 1 -> util.showStock(linkedList);
                case 2 -> {
                    System.out.println("Introduce el número de producto que quires eliminar del stock");
                    int inId = util.inInt();
                    util.deleteById(linkedList, inId);
                }
                case 3 -> {
                    System.out.println("1-Introducir Comic");
                    System.out.println("2-Introducir Libro");
                    int typeProduct = util.inInt();
                    /* introduciendo nuevo Producto 1->Comic 2->Libro */
                    if(typeProduct == 1){
                        System.out.println("Introduce el titulo");
                        String inTitulo = util.inStr();
                        System.out.println("Introduce el dibujante");
                        String inDibujante = util.inStr();
                        System.out.println("Introduce el guionista");
                        String inGuionista = util.inStr();
                        Comic newComic = new Comic(inTitulo, Util.id++, inGuionista, inDibujante);
                        util.addNewItem(linkedList, newComic);
                    } else { 
                        System.out.println("Introduce el titulo");
                        String inTitulo = util.inStr();
                        System.out.println("Introduce el author");
                        String inAuthor = util.inStr();
                        Libro newLibro = new Libro(inTitulo, Util.id++, inAuthor);
                        util.addNewItem(linkedList, newLibro);
                    }
                    util.saveLinkedListToTxt(linkedList);
                }
                case 4 -> {
                    System.out.println("Ahora sacamos el contenido de nuesto archivo");
                    util.saveLinkedListToTxt(linkedList);
                    util.readTxt();
                    System.out.println("");
                }
            }
            util.showMenu(); 
        }
        if(inValue == 5){
            System.out.println("Gracias por la visita!");
            System.out.println(" Esperamos a verle pronto");
        }
       
    }
    
}
