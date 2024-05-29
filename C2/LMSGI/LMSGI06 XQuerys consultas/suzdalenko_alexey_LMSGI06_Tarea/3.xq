let $cruceros := doc("cruceros.xml")/cruceros/crucero[precio/base > 600]
let $crucerosFiltrados :=
    for $crucero in $cruceros
    where $crucero/frecuencia = "cada_mes"
    order by $crucero/nombre
    return $crucero
    
let $response :=
    for $crucero in $crucerosFiltrados
    return
        <crucero>
            <nombre>{data($crucero/nombre)}</nombre>
            <recorrido>{
                for $etapa in $crucero/recorrido/etapa
                return
                    <etapa numero="{@numero}">
                        <puerto_salida>{data($etapa/puerto_salida)}</puerto_salida>
                        <dias>{data($etapa/dias)}</dias>
                    </etapa>
            }</recorrido>
        </crucero>

return $response
