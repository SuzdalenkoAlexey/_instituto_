<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" encoding="UTF-8"/>
  <xsl:template match="/">
    <html>
      <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
      </head>
      <body>
        <div class="wrapper">
            <div class="inner">
                <h2>Patrimonio arquitectonico de Andalucía y Galicia</h2>
            </div>
        <table>
          <tr>
            <th>Cuidad</th>
            <th>Comunidad Autónoma</th>
            <th>Numero de habitantes</th>
            <th>Nombre</th>
            <th>Siglo</th>
          </tr>
            <xsl:for-each select="//ComunidadAutonoma[NombreCA='Andalucía' or //ComunidadAutonoma[NombreCA='Galicia']">
                <xsl:variable name="id_comunidad_autonoma" select="@codigo" />
                <xsl:for-each select="//Ciudad/[CCAA=id_comunidad_autonoma]">
                    <tr>
                        <td><xsl:value-of select="//Ciudad/Nombre"/></td>
                        <td><xsl:value-of select="//ComunidadAutonoma/NombreCA"/></td>
                        <td><xsl:value-of select="//ComunidadAutonoma/NumeroHabitantes"/></td>
                        <td><xsl:value-of select="//Ciudad/PatrimonioArquitectonico/Elemento/Nombre"/></td>
		                <td><xsl:value-of select="//Ciudad/PatrimonioArquitectonico/Elemento/SigloOrigen"/></td>
                    </tr>
                </xsl:for-each>
            </xsl:for-each>
        </table>
        </div>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
