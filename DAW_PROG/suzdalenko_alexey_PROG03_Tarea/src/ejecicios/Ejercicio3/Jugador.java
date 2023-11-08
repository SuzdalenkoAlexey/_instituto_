package ejecicios.Ejercicio3;

public class Jugador {
    private int energia;
    private String nombre;
    private Boolean defensa;
    
    public Jugador(){
        this.energia = 100;
        this.nombre = "Conan";
        this.defensa = false;
    }
    public Jugador(String nombre){
        this.energia = 100;
        this.nombre = nombre;
        this.defensa = false;
    }
    public void Atacar(Jugador oponente){
        System.out.println(this.GetNombre()+" Ataca");
        if(oponente.GetDefensa()){
            oponente.SetDefensa(false);
        } else {
            int energiaOponente = oponente.GetEnergia();
                energiaOponente = energiaOponente - 25;
                oponente.SetEnergia(energiaOponente);
        }
        System.out.println("Sacamos el estado actual de ambos jugadores");
    }
    public void Defender(){
        this.defensa = true;
    }
    public void mostrarEstado(){
        System.out.println("Nombre: "+this.GetNombre());
        System.out.println("Energia: "+ this.GetEnergia());
        System.out.println("Defensa: "+this.GetDefensa());
    }
    
    
    public void SetEnergia(int energia){
        this.energia = energia;
    }
    public int GetEnergia(){
        return this.energia;
    }
    public void SetNombre(String nombre){
        this.nombre = nombre;
    }
    public String GetNombre(){
        return this.nombre;
    }
    public void SetDefensa(Boolean defensa){
        this.defensa = defensa;
    }
    public Boolean GetDefensa(){
        return this.defensa;
    }
}
