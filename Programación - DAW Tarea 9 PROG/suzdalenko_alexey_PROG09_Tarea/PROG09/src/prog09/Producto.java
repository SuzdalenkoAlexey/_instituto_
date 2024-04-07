package prog09;

abstract class Producto {
    protected String titulo;
    protected int id;
    protected String tipoProducto;
    public Producto(){}
    public Producto(String titulo, int id, String tipoProducto){
        this.titulo = titulo;
        this.id = id;
        this.tipoProducto = tipoProducto;
    }
    abstract String getTitulo();
    abstract void setTitulo(String titulo);
    abstract int getId();
    abstract String getTipoProducto();
}
