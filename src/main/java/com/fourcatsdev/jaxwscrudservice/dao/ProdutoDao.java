package com.fourcatsdev.jaxwscrudservice.dao;

import java.sql.SQLException;
import java.util.List;
import com.fourcatsdev.jaxwscrudservice.modelo.Produto;

public interface ProdutoDao {
	public long adicionar(Produto produto) throws SQLException;
	public Produto alterar(Produto produto) throws SQLException;
	public boolean apagar(Long id) throws SQLException;
	public List<Produto> listar() throws SQLException;
	public Produto ler(long id) throws SQLException;
}