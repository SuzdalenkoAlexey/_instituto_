let $puertosEspana := ("Barcelona", "Valencia")
let $misCruceros := doc("cruceros.xml")/cruceros/crucero[recorrido/puerto_salida = $puertosEspana]

return
    for $c in $misCruceros
    return
        <crucero>
            <nombre>{data($c/nombre)}</nombre>
            <puerto_salida>{data($c/recorrido/puerto_salida)}</puerto_salida>
            <dias_crucero>{sum($c/recorrido/etapa/dias)}</dias_crucero>
        </crucero>
        