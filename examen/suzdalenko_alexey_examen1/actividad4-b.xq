let $cuidades := doc("Ejercicio_LMSGI.xml")/Ciudad/Estadisticas/Economicas[RentaPerCapita > 20000]
let $cuidadesFiltradas :=
    for $c in $cuidades
    where $c/Estadisticas/PorcentajeMayores65 > 20 and $c/Estadisticas/NumeroHijosPorMujer < 1.3 
    return $c
    
let $response :=
    for $c in $cuidadesFiltradas
    return
        <Cuidad>
            <Nombre>{data($c/Nombre)}</Nombre>
            <NumeroHabitantes>{data($c/Estadisticas/Demograficas/NumeroHabitantes)}</NumeroHabitantes>
        </Cuidad>

return '<Cuidades>' + '$response + '</Cuidades>'