
package com.uy.financialApp.financialTools.acciones.external.cotiza;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para wsmonedasout complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="wsmonedasout"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="wsmonedasout.Linea" type="{Cotiza}wsmonedasout.Linea" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsmonedasout", propOrder = {
    "wsmonedasoutLinea"
})
public class Wsmonedasout {

    @XmlElement(name = "wsmonedasout.Linea")
    protected List<WsmonedasoutLinea> wsmonedasoutLinea;

    /**
     * Gets the value of the wsmonedasoutLinea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsmonedasoutLinea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsmonedasoutLinea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsmonedasoutLinea }
     * 
     * 
     */
    public List<WsmonedasoutLinea> getWsmonedasoutLinea() {
        if (wsmonedasoutLinea == null) {
            wsmonedasoutLinea = new ArrayList<WsmonedasoutLinea>();
        }
        return this.wsmonedasoutLinea;
    }

}
