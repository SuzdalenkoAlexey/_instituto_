package tarea5;

public class NovelaGrafica extends Comic {
    private int numPag;
    
    public NovelaGrafica(){}
    
    public NovelaGrafica(String Titulo, String Guionista, String Dibujante, int Numero, int numPag){
        super(Titulo, Guionista, Dibujante, Numero);
        this.numPag = numPag;
    }
    
    public int getNumPag(){ return this.numPag; }
    
    @Override
    public void mostrarInformacion(){
        System.out.println("El comic "+this.getTitulo()+" "+this.getNumero()+" fue guionizado por "+this.getGuionista()+" y dibujado por "+this.getDibujante());
        System.out.println("Esta novela grafica tendra "+this.getNumPag()+ "paginas");
    } 
}
