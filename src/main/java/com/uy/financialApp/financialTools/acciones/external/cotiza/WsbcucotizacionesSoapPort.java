
package com.uy.financialApp.financialTools.acciones.external.cotiza;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "wsbcucotizacionesSoapPort", targetNamespace = "Cotiza")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WsbcucotizacionesSoapPort {


    /**
     * 
     * @param parameters
     * @return
     *     returns cotiza.WsbcucotizacionesExecuteResponse
     */
    @WebMethod(operationName = "Execute", action = "Cotizaaction/AWSBCUCOTIZACIONES.Execute")
    @WebResult(name = "wsbcucotizaciones.ExecuteResponse", targetNamespace = "Cotiza", partName = "parameters")
    public WsbcucotizacionesExecuteResponse execute(
        @WebParam(name = "wsbcucotizaciones.Execute", targetNamespace = "Cotiza", partName = "parameters")
        WsbcucotizacionesExecute parameters);

}
