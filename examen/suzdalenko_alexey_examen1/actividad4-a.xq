let $comunidades := doc("Ejercicio_LMSGI.xml")/[NumeroHabitantes > 2000000]
    
let $response :=
    for $comunidad in $comunidadesFiltradas
    return
        <CCAA>
            <NombreCA>{data($comunidad/NombreCA)}</NombreCA>
            <NumeroHabitantes>{data($comunidad/NumeroHabitantes)}</NumeroHabitantes>
            <Extension>{data($comunidad/Extension)}</Extension>
        </CCAA>

return $response