package tarea5;
public class CreaComic {

    public static void main(String[] args) {
       Comic c1 = new Comic("Watchmen", "Alan Moore", "Dave Gibbons", 3);
       System.out.println("El titulo de comic es "+ c1.getTitulo());
       System.out.println("--------------------------------------");
        
       Comic[] arrayComic = new Comic[12];
       for(int i = 0; i < 12; i++){
           arrayComic[i] = new Comic("Watchmen", "Alan Moore", "Dave Gibbons", i+1); 
       }
       
       for(Comic comic: arrayComic){
           comic.mostrarInformacion();
       }
       System.out.println("--------------------------------------");
       
       NovelaGrafica novelaGrafica = new NovelaGrafica("Los Campbell: El Oro de San Brandamo", "José Luis Munuera", "José Luis Munuera", 5, 56);
       novelaGrafica.mostrarInformacion();
    }
}
