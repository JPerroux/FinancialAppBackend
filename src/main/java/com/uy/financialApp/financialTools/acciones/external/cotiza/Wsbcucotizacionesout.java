
package com.uy.financialApp.financialTools.acciones.external.cotiza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para wsbcucotizacionesout complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="wsbcucotizacionesout"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="respuestastatus" type="{Cotiza}respuestastatus"/&gt;
 *         &lt;element name="datoscotizaciones" type="{Cotiza}datoscotizaciones"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsbcucotizacionesout", propOrder = {
    "respuestastatus",
    "datoscotizaciones"
})
public class Wsbcucotizacionesout {

    @XmlElement(required = true)
    protected Respuestastatus respuestastatus;
    @XmlElement(required = true)
    protected Datoscotizaciones datoscotizaciones;

    /**
     * Obtiene el valor de la propiedad respuestastatus.
     * 
     * @return
     *     possible object is
     *     {@link Respuestastatus }
     *     
     */
    public Respuestastatus getRespuestastatus() {
        return respuestastatus;
    }

    /**
     * Define el valor de la propiedad respuestastatus.
     * 
     * @param value
     *     allowed object is
     *     {@link Respuestastatus }
     *     
     */
    public void setRespuestastatus(Respuestastatus value) {
        this.respuestastatus = value;
    }

    /**
     * Obtiene el valor de la propiedad datoscotizaciones.
     * 
     * @return
     *     possible object is
     *     {@link Datoscotizaciones }
     *     
     */
    public Datoscotizaciones getDatoscotizaciones() {
        return datoscotizaciones;
    }

    /**
     * Define el valor de la propiedad datoscotizaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link Datoscotizaciones }
     *     
     */
    public void setDatoscotizaciones(Datoscotizaciones value) {
        this.datoscotizaciones = value;
    }

}
