
package com.fourcatsdev.jaxwscrudservice.servico.jaxws;

import java.util.List;
import com.fourcatsdev.jaxwscrudservice.modelo.Produto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listarResponse", namespace = "http://servico.jaxwscrudservice.fourcatsdev.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarResponse", namespace = "http://servico.jaxwscrudservice.fourcatsdev.com/")
public class ListarResponse {

    @XmlElement(name = "return", namespace = "")
    private List<Produto> _return;

    /**
     * 
     * @return
     *     returns List<Produto>
     */
    public List<Produto> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<Produto> _return) {
        this._return = _return;
    }

}
