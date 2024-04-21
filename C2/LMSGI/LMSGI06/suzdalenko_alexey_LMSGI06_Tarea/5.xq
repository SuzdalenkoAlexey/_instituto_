let $crucerosBari := doc("cruceros.xml")/cruceros/crucero[recorrido/puerto_salida = "Bari" 
    or recorrido/etapa/puerto = "Bari"]

return
    for $c in $crucerosBari
    return
        <crucero>
            <nombre>{data($c/nombre)}</nombre>
            <puerto_salida>{data($c/recorrido/puerto_salida)}</puerto_salida>
            <precio_en_camarote_exterior>
                {
                    let $precioBase := xs:decimal($c/precio/base)
                    let $precioExtra := xs:decimal($c/precio/extra_camarote_exterior)
                    return $precioBase + $precioExtra
                }
            </precio_en_camarote_exterior>
        </crucero>
