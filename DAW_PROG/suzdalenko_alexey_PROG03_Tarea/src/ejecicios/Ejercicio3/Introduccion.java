package ejecicios.Ejercicio3;

public class Introduccion {
    private String leenda;
    
    public Introduccion(){}
    
    public void SetLeenda(){
        this.leenda = """
                      Sabed, oh, pr\u00edncipe, que entre los a\u00f1os del hundimiento de Atlantis y de las resplandecientes
                      ciudades bajo los oc\u00e9anos, y los de la aparici\u00f3n de los hijos de Aryas, hubo una edad olvidada en
                      la que el mundo estaba cubierto de brillantes reinos como mantos azules bajo las estrellas:
                      Nemedia, Ofir, Brithunia, Hiperborea: Zamora con sus muchachas de oscuros cabellos y sus torres
                      plagadas de ar\u00e1cnidos misterios: Zingara y sus caballeros: Koth, lim\u00edtrofe con las tierras
                      pastoriles de Shem: Estigia con sus tumbas custodiadas por sombras e Hirkania, cuyos jefes
                      vest\u00edan acero, seda y oro. Pero el m\u00e1s orgulloso reino del mundo era Aquilonia, que reinaba
                      soberana sobre el so\u00f1oliento oeste. Y aqu\u00ed llego Conan, el cimmerio de pelo negro, los ojos
                      sombr\u00edos, la espada en la mano, un saqueador, un asesino de gigantes melancol\u00edas y gigantescas
                      alegr\u00edas, para pisotear con sus sandalias los enjoyados tronos de la Tierra""";
    }
    public String GetLeenda(){
        return this.leenda;
    }
}
