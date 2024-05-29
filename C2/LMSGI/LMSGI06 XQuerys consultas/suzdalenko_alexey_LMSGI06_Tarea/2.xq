let $puertos := doc("puertos.xml")/puertos/puerto
let $numeroPuertosEspaña := count($puertos[pais = "España"])
return <NumeroDePuertosEnEspaña>{$numeroPuertosEspaña}</NumeroDePuertosEnEspaña>
