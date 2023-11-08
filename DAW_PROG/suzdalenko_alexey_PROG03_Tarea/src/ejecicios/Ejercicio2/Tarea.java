package ejecicios.Ejercicio2;

public class Tarea {
    private String descipcion;
    private String fecha;
    private int prioridad;
    private Boolean completada;
    
    public Tarea(){}
    
    public void setDesciption(String descipcion){
        this.descipcion = descipcion;
    }
    public String getDescription(){
        return this.descipcion;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public String getFecha(){
        return this.fecha;
    }
    public void setPrioridad(int prioridad){
        this.prioridad = prioridad;
    }
    public int getPrioridad(){
        return this.prioridad;
    }
    public void setCompletada(Boolean completada){
        this.completada = completada;
    }
    public Boolean getCompletada(){
        return this.completada;
    }
    
    public void aumentarPrioridad(){
        this.prioridad++;
        if(this.prioridad > 10) this.prioridad = 10;
    }
    public void disminuirPrioridad(){
        this.prioridad--;
        if(this.prioridad < 1) this.prioridad = 1;
    }
}
