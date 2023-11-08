package ejecicios.Ejercicio3;

public class Juego {
    public static void main(String[] args) {
        String miSeparador = "**********************************";
        Jugador jConan = new Jugador();
        Jugador jThothAmon = new Jugador("Thoth-Amon");
        Introduccion introduccion = new Introduccion();
        introduccion.SetLeenda();
        
        System.out.println(introduccion.GetLeenda());
        System.out.println(miSeparador);
        
        jConan.mostrarEstado();
        System.out.println(miSeparador);
        
        jThothAmon.mostrarEstado();
        System.out.println(miSeparador);
        
        jConan.Atacar(jThothAmon);
        System.out.println(miSeparador);
        
        jConan.mostrarEstado();
        System.out.println(miSeparador);
        
        jThothAmon.mostrarEstado();
        System.out.println(miSeparador);
        
        System.out.println("Thoth-Amon utiliza un escudo para salvarse de la siguiente acometida de Conan");
        jThothAmon.Defender();
        System.out.println("Vamos a su estado actual");
        jThothAmon.mostrarEstado();
        System.out.println(miSeparador);
        
        jConan.Atacar(jThothAmon);
        System.out.println(miSeparador);
        
        jConan.mostrarEstado();
        System.out.println(miSeparador);
        
        jThothAmon.mostrarEstado();
        System.out.println(miSeparador);
    }
}
