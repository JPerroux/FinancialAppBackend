
package com.uy.financialApp.financialTools.acciones.external.cotiza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Salida" type="{Cotiza}wsmonedasout"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "salida"
})
@XmlRootElement(name = "wsbcumonedas.ExecuteResponse")
public class WsbcumonedasExecuteResponse {

    @XmlElement(name = "Salida", required = true)
    protected Wsmonedasout salida;

    /**
     * Obtiene el valor de la propiedad salida.
     * 
     * @return
     *     possible object is
     *     {@link Wsmonedasout }
     *     
     */
    public Wsmonedasout getSalida() {
        return salida;
    }

    /**
     * Define el valor de la propiedad salida.
     * 
     * @param value
     *     allowed object is
     *     {@link Wsmonedasout }
     *     
     */
    public void setSalida(Wsmonedasout value) {
        this.salida = value;
    }

}
