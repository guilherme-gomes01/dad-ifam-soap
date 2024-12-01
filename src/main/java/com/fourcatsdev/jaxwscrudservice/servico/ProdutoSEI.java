package com.fourcatsdev.jaxwscrudservice.servico;

import java.util.List;

import com.fourcatsdev.jaxwscrudservice.modelo.Produto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding (style = Style.DOCUMENT)
public interface ProdutoSEI {

	@WebMethod
	public long adicionar(Produto produto);
	@WebMethod
	public Produto alterar(Produto produto);
	@WebMethod
	public boolean apagar(long id);
	@WebMethod
	public List<Produto> listar();
	@WebMethod
	public Produto ler(long id);
}
