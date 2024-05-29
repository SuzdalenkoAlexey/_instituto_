let $cruceros := doc("cruceros.xml")/cruceros/crucero[frecuencia = "cada_dos_meses"]

return
    for $c in $cruceros
    return
        <crucero>
            <nombre>{data($c/nombre)}</nombre>
            <numero_de_etapas>{count($c/recorrido/etapa)}</numero_de_etapas>
        </crucero>
