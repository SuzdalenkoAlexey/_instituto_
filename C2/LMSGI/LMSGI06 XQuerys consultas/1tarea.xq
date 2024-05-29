for $puerto in doc("puertos.xml")/puertos/puerto[pais = 'Italia']
return <puerto><nombre>{$puerto/nombre/text()}</nombre></puerto>