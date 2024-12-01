package com.fourcatsdev.jaxwscrudservice.servico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fourcatsdev.jaxwscrudservice.dao.ProdutoDao;
import com.fourcatsdev.jaxwscrudservice.dao.ProdutoImpl;
import com.fourcatsdev.jaxwscrudservice.modelo.Produto;
import com.fourcatsdev.jaxwscrudservice.util.Conexao;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.fourcatsdev.jaxwscrudservice.servico.ProdutoSEI")
public class ProdutoSIB implements ProdutoSEI {

	@Override
	public long adicionar(Produto produto) {
		Connection con = Conexao.getConnection();
		ProdutoDao dao = new ProdutoImpl(con);
		long id = 0;
		try{
			id = dao.adicionar(produto);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Produto alterar(Produto produto) {
		Connection con = Conexao.getConnection();
		ProdutoDao dao = new ProdutoImpl(con);
		Produto prod = null;
		try{
			prod = dao.alterar(produto);
			return prod;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public boolean apagar(long id) {
		Connection con = Conexao.getConnection();
		ProdutoDao dao = new ProdutoImpl(con);
		try{
			return dao.apagar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Produto> listar() {
		Connection con = Conexao.getConnection();
		ProdutoDao dao = new ProdutoImpl(con);
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			produtos = dao.listar();
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	@Override
	public Produto ler(long id) {
		Connection con = Conexao.getConnection();
		ProdutoDao dao = new ProdutoImpl(con);
		Produto prod = null;
		try {
			prod = dao.ler(id);
			return prod;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;
	}
}
