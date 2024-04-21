<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Grados de Facultad de Ciencias</title>
                <link rel="stylesheet" href="style.css" />
            </head>
            <body>
                <div class="wrapper">
                    <h1>Grados de Facultad de Ciencias</h1>
                    <ul>
                        <xsl:apply-templates select="//grado[centro='Facultad de Ciencias']"/>
                    </ul>    
                    <div class="centered">
                        <h3>Listado de asignaturas Troncales (2T) de la Facultad de Ciencia</h3>  
                    <table>
                        <tr>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Titulación</th>
                            <th>Creditos teoricos</th>
                            <th>Practicas</th>
                            <th>Comentario</th>
                        </tr>
                        <xsl:apply-templates select="//asignatura[//grado[centro='Facultad de Ciencias'] and trimestre='2' and caracteristicas/tipo='Troncal']">
                            <xsl:sort select="creditos_teoricos" data-type="number"/>
                        </xsl:apply-templates>
                    </table>
                    </div> 
                </div>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="grado">
        <li>
            (<xsl:value-of select="@id_c"/>)
            <b><xsl:value-of select="nombre"/></b>
            <xsl:text> - Plan: </xsl:text>
            <xsl:value-of select="plan"/>
        </li>
    </xsl:template>
    
    <xsl:template match="asignatura">
        <tr>
            <td><xsl:value-of select="@id_a"/></td>
            <td><xsl:value-of select="nombre"/></td>
            <td>
                <xsl:variable name="codigo_grado" select="@titulacion"/>
                <xsl:value-of select="//grado[@id_c=$codigo_grado]/nombre"/>
            </td>
            <td><xsl:value-of select="creditos_teoricos"/></td>
            <td><xsl:value-of select="caracteristicas/practicas"/></td>
            <td>
                <xsl:choose>
                    <xsl:when test="not(creditos_teoricos) or creditos_teoricos = ''">Sin información</xsl:when>
                    <xsl:when test="creditos_teoricos &lt; 2">Corta</xsl:when>
                    <xsl:when test="creditos_teoricos &gt;= 2 and creditos_teoricos &lt;= 5">Media</xsl:when>
                    <xsl:when test="creditos_teoricos &gt; 5">Larga</xsl:when>
                </xsl:choose>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>


<!-- 
      <xsl:text> </xsl:text> > empty string
-->