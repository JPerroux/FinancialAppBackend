
package com.uy.financialApp.financialTools.acciones.external.cotiza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para wsbcucotizacionesin complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="wsbcucotizacionesin"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Moneda" type="{Cotiza}ArrayOfint"/&gt;
 *         &lt;element name="FechaDesde" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="FechaHasta" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="Grupo" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsbcucotizacionesin", propOrder = {
    "moneda",
    "fechaDesde",
    "fechaHasta",
    "grupo"
})
public class Wsbcucotizacionesin {

    @XmlElement(name = "Moneda", required = true)
    protected ArrayOfint moneda;
    @XmlElement(name = "FechaDesde", required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaDesde;
    @XmlElement(name = "FechaHasta", required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaHasta;
    @XmlElement(name = "Grupo")
    protected byte grupo;

    /**
     * Obtiene el valor de la propiedad moneda.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfint }
     *     
     */
    public ArrayOfint getMoneda() {
        return moneda;
    }

    /**
     * Define el valor de la propiedad moneda.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfint }
     *     
     */
    public void setMoneda(ArrayOfint value) {
        this.moneda = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDesde.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Define el valor de la propiedad fechaDesde.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDesde(XMLGregorianCalendar value) {
        this.fechaDesde = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHasta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Define el valor de la propiedad fechaHasta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHasta(XMLGregorianCalendar value) {
        this.fechaHasta = value;
    }

    /**
     * Obtiene el valor de la propiedad grupo.
     * 
     */
    public byte getGrupo() {
        return grupo;
    }

    /**
     * Define el valor de la propiedad grupo.
     * 
     */
    public void setGrupo(byte value) {
        this.grupo = value;
    }

}
