package tarea08;

public class Pregunta {
    private char Identificador;
    private String Enunciado;
    private String Respuesta;
    private String Respuesta_correcta;
    
    public Pregunta(){}
    public Pregunta(char Indentificador, String Enunciado, String Respuesta){
        this.Identificador = Indentificador;
        this.Enunciado = Enunciado;
        this.Respuesta = Respuesta;
        this.Respuesta_correcta = "Azul";
    }
        
    public void cambiaRespuestaCorrecta(){ this.Respuesta_correcta = "Verde"; }
    public void cambiaRespuestaIncorrecta(){ this.Respuesta_correcta = "Rojo"; }
    public void cambiaPasapalabra(){ this.Respuesta_correcta = "Azul"; }
    public char getIdentificador(){ return this.Identificador; }
    public String getEnunciado(){ return this.Enunciado; }
    
    public String getRespuesta(){ return this.Respuesta; }  
    public String getRespuesta_correcta(){ return this.Respuesta_correcta; }

}
