package prog09;

public class Comic extends Producto {
    private String dibujante;
    private String guionista;
    public Comic(String titulo, int id, String guionista, String dibujante) {
        super(titulo, id);
        this.guionista = guionista;
        this.dibujante = dibujante;
    }

    @Override
    String getTitulo() { return this.titulo; }
    @Override
    void setTitulo(String titulo) {  this.titulo = titulo; }
    @Override
    int getId() { return this.id; }
    
    public void setDibujante(String dibujante){ this.dibujante = dibujante; } 
    public void setGuionista(String guionista){ this.guionista = guionista; }
    public String getGuionista(){ return this.guionista; }
    public String getDibujante(){ return this.dibujante; }
}
