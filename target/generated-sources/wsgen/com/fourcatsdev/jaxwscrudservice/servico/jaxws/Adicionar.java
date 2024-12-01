
package com.fourcatsdev.jaxwscrudservice.servico.jaxws;

import com.fourcatsdev.jaxwscrudservice.modelo.Produto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "adicionar", namespace = "http://servico.jaxwscrudservice.fourcatsdev.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adicionar", namespace = "http://servico.jaxwscrudservice.fourcatsdev.com/")
public class Adicionar {

    @XmlElement(name = "arg0", namespace = "")
    private Produto arg0;

    /**
     * 
     * @return
     *     returns Produto
     */
    public Produto getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(Produto arg0) {
        this.arg0 = arg0;
    }

}
