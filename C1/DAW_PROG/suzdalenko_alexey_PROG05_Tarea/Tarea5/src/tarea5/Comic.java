package tarea5;

public class Comic {
    private String Titulo;
    private String Guionista;
    private String Dibujante;
    private int Numero;
    public Comic(){}
    public Comic(String Titulo, String Guionista, String Dibujante, int Numero){
        this.Titulo = Titulo;
        this.Guionista = Guionista;
        this.Dibujante = Dibujante;
        this.Numero = Numero;
    }
    
    public String getTitulo(){ return this.Titulo; }
    public String getGuionista(){ return this.Guionista; }
    public String getDibujante(){ return this.Dibujante; }
    public int getNumero(){ return this.Numero; }
    public void setTitulo(String Titulo){ this.Titulo = Titulo; }
    public void setGuionista(String Guionista){ this.Guionista = Guionista; }
    public void setDibujante(String Dibujante){ this.Dibujante = Dibujante; }
    public void setNumero(int Numero){ this.Numero = Numero; }
    
    public void mostrarInformacion(){
        System.out.println("El comic "+this.getTitulo()+" "+this.getNumero()+" fue guionizado por "+this.getGuionista()+" y dibujado por "+this.getDibujante());
    } 
}
