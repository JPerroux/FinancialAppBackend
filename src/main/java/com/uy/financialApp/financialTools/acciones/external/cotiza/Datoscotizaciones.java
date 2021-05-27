
package com.uy.financialApp.financialTools.acciones.external.cotiza;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para datoscotizaciones complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="datoscotizaciones"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datoscotizaciones.dato" type="{Cotiza}datoscotizaciones.dato" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datoscotizaciones", propOrder = {
    "datoscotizacionesDato"
})
public class Datoscotizaciones {

    @XmlElement(name = "datoscotizaciones.dato")
    protected List<DatoscotizacionesDato> datoscotizacionesDato;

    /**
     * Gets the value of the datoscotizacionesDato property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datoscotizacionesDato property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatoscotizacionesDato().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatoscotizacionesDato }
     * 
     * 
     */
    public List<DatoscotizacionesDato> getDatoscotizacionesDato() {
        if (datoscotizacionesDato == null) {
            datoscotizacionesDato = new ArrayList<DatoscotizacionesDato>();
        }
        return this.datoscotizacionesDato;
    }

}
