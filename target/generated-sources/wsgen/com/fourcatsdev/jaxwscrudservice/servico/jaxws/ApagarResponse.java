
package com.fourcatsdev.jaxwscrudservice.servico.jaxws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "apagarResponse", namespace = "http://servico.jaxwscrudservice.fourcatsdev.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "apagarResponse", namespace = "http://servico.jaxwscrudservice.fourcatsdev.com/")
public class ApagarResponse {

    @XmlElement(name = "return", namespace = "")
    private boolean _return;

    /**
     * 
     * @return
     *     returns boolean
     */
    public boolean isReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(boolean _return) {
        this._return = _return;
    }

}
