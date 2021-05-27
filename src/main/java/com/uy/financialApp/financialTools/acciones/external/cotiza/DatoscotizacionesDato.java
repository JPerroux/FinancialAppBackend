
package com.uy.financialApp.financialTools.acciones.external.cotiza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para datoscotizaciones.dato complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="datoscotizaciones.dato"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="Moneda" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CodigoISO" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Emisor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TCC" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="TCV" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ArbAct" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="FormaArbitrar" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datoscotizaciones.dato", propOrder = {
    "fecha",
    "moneda",
    "nombre",
    "codigoISO",
    "emisor",
    "tcc",
    "tcv",
    "arbAct",
    "formaArbitrar"
})
public class DatoscotizacionesDato {

    @XmlElement(name = "Fecha", required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "Moneda")
    protected short moneda;
    @XmlElement(name = "Nombre", required = true)
    protected String nombre;
    @XmlElement(name = "CodigoISO", required = true)
    protected String codigoISO;
    @XmlElement(name = "Emisor", required = true)
    protected String emisor;
    @XmlElement(name = "TCC")
    protected double tcc;
    @XmlElement(name = "TCV")
    protected double tcv;
    @XmlElement(name = "ArbAct")
    protected double arbAct;
    @XmlElement(name = "FormaArbitrar")
    protected byte formaArbitrar;

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad moneda.
     * 
     */
    public short getMoneda() {
        return moneda;
    }

    /**
     * Define el valor de la propiedad moneda.
     * 
     */
    public void setMoneda(short value) {
        this.moneda = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoISO.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoISO() {
        return codigoISO;
    }

    /**
     * Define el valor de la propiedad codigoISO.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoISO(String value) {
        this.codigoISO = value;
    }

    /**
     * Obtiene el valor de la propiedad emisor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * Define el valor de la propiedad emisor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmisor(String value) {
        this.emisor = value;
    }

    /**
     * Obtiene el valor de la propiedad tcc.
     * 
     */
    public double getTCC() {
        return tcc;
    }

    /**
     * Define el valor de la propiedad tcc.
     * 
     */
    public void setTCC(double value) {
        this.tcc = value;
    }

    /**
     * Obtiene el valor de la propiedad tcv.
     * 
     */
    public double getTCV() {
        return tcv;
    }

    /**
     * Define el valor de la propiedad tcv.
     * 
     */
    public void setTCV(double value) {
        this.tcv = value;
    }

    /**
     * Obtiene el valor de la propiedad arbAct.
     * 
     */
    public double getArbAct() {
        return arbAct;
    }

    /**
     * Define el valor de la propiedad arbAct.
     * 
     */
    public void setArbAct(double value) {
        this.arbAct = value;
    }

    /**
     * Obtiene el valor de la propiedad formaArbitrar.
     * 
     */
    public byte getFormaArbitrar() {
        return formaArbitrar;
    }

    /**
     * Define el valor de la propiedad formaArbitrar.
     * 
     */
    public void setFormaArbitrar(byte value) {
        this.formaArbitrar = value;
    }

}
