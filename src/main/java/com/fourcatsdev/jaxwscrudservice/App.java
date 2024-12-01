package com.fourcatsdev.jaxwscrudservice;

import com.fourcatsdev.jaxwscrudservice.servico.ProdutoSIB;
import jakarta.xml.ws.Endpoint;

public class App {
    public static void main( String[] args ) {
    	String porta = "8088";
		System.out.println("Publicando o serviço na porta: " + porta);
		Endpoint.publish("http://localhost:"+porta+"/produtos", new ProdutoSIB());
		System.out.println("Serviço publicado na porta: " + porta);
    }
}
