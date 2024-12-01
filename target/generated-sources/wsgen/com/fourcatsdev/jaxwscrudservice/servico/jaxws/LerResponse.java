
package com.fourcatsdev.jaxwscrudservice.servico.jaxws;

import com.fourcatsdev.jaxwscrudservice.modelo.Produto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "lerResponse", namespace = "http://servico.jaxwscrudservice.fourcatsdev.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lerResponse", namespace = "http://servico.jaxwscrudservice.fourcatsdev.com/")
public class LerResponse {

    @XmlElement(name = "return", namespace = "")
    private Produto _return;

    /**
     * 
     * @return
     *     returns Produto
     */
    public Produto getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Produto _return) {
        this._return = _return;
    }

}
