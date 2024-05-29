<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" encoding="UTF-8"/>
  
  <!-- Enlace al archivo CSS -->
  <xsl:template match="/">
    <html>
      <head>
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
      </head>
      <body>
        <!-- Lista de grados en la Facultad de Ciencias -->
        <h2>Grados en la Facultad de Ciencias:</h2>
        <ul>
          <xsl:for-each select="//grado[centro='Facultad de Ciencias']">
            <li>
              <xsl:value-of select="concat('(', @id_c, ') ', nombre, ' - Plan ', plan)"/>
            </li>
          </xsl:for-each>
        </ul>
        
        <!-- Tabla de asignaturas troncales del segundo trimestre en la Facultad de Ciencias -->
        <h2>Asignaturas troncales del segundo trimestre en la Facultad de Ciencias:</h2>
        <table>
          <tr>
            <th>Código de asignatura</th>
            <th>Nombre de asignatura</th>
            <th>Titulación</th>
            <th>Créditos teóricos</th>
            <th>Tiene prácticas</th>
            <th>Comentario</th>
          </tr>
          <xsl:for-each select="//asignatura[trimestre=2 and caracteristicas/tipo='Troncal' and ../grados/centro='Facultad de Ciencias']">
            <xsl:sort select="creditos_teoricos" data-type="number"/>
            <tr>
						
						<xsl:variable name="id_titulacion" select="@titulacion" /> ahora video (xml code editor, notepad++)
						
              <td><xsl:value-of select="@id_a"/></td>
              <td><xsl:value-of select="nombre"/></td>
              <td><xsl:value-of select="../grados/grado[@id_c=current()/@titulacion]/nombre"/></td>
			  
						<xsl:value-of select="//grados/grado[@id_c=id_titulacion]/nombre"/> ahora video (xml code editor, notepad++)
              
			  <td><xsl:value-of select="creditos_teoricos"/></td>
              <td><xsl:value-of select="caracteristicas/practicas"/></td>
              <td>
                <xsl:choose>
                  <xsl:when test="creditos_teoricos &lt; 2">Corta</xsl:when>
                  <xsl:when test="creditos_teoricos &gt;= 2 and creditos_teoricos &lt;= 5">Media</xsl:when>
                  <xsl:when test="creditos_teoricos &gt; 5">Larga</xsl:when>
                  <xsl:otherwise>Sin información</xsl:otherwise>
                </xsl:choose>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
