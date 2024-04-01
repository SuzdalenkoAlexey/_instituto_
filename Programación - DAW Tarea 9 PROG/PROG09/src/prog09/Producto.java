package prog09;

abstract class Producto {
    protected String titulo;
    protected int id;
    public Producto(){}
    public Producto(String titulo, int id){
        this.titulo = titulo;
        this.id = id;
    }
    abstract String getTitulo();
    abstract void setTitulo(String titulo);
    abstract int getId();
}
