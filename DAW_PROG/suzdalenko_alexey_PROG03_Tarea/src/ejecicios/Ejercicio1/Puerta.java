package ejecicios.Ejercicio1;

public class Puerta {
    private Integer ancho;
    private Integer largo;
    private Boolean abierta;
    
    public Puerta(){
        this.ancho = 3;
        this.largo = 2;
        this.abierta = false;
    }
    public void SetAncho(Integer ancho){
        this.ancho = ancho;
    }
    public Integer GetAncho(){
        return this.ancho;
    }
    public void SetLargo(Integer largo){
        this.largo = largo;
    }
    public Integer GetLargo(){
        return this.largo;
    }
    public String mostrarEstado(){
        if(this.abierta) return "abierta";
        return "cerrada";
    }
    public void Abrir(){
        this.abierta = true;
    }
    public void Cerrar(){
        this.abierta = false;
    }
}
