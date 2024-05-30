<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    
    <xsl:template match="Nombre">
        <xsl:value-of select="Nombre"/>,  
    </xsl:template>
    
    <xsl:template match="Ciudad">
        <xsl:apply-templates select="Nombre"></xsl:apply-templates>
    </xsl:template>
</xsl:stylesheet>