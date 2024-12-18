package com.fourcatsdev.jaxwscrudservice.dao;

import com.fourcatsdev.jaxwscrudservice.modelo.Produto;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPFactory;
import jakarta.xml.soap.SOAPFault;
import jakarta.xml.ws.soap.SOAPFaultException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProdutoImpl implements ProdutoDao{

	private static final Logger logger = Logger.getLogger(ProdutoImpl.class.getName());
	private final Connection connection;
	public ProdutoImpl(Connection connection) {
		this.connection = connection;
	}

	public long adicionar(Produto produto) {
		Long id = null;
		String sql = "INSERT INTO produto (nome, quantidade, preco_unitario, data_cadastro) "
				+ "VALUES (?, ?, ?, ?) RETURNING id";
		PreparedStatement stmt = null;

		try {
			validarProduto(produto);
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setInt(2, produto.getQuantidade());
			stmt.setDouble(3, produto.getPreco());

			if (produto.getData() != null) {
				stmt.setDate(4, new java.sql.Date(produto.getData().getTime()));
			} else {
				stmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			}
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getLong("id");
			}

		} catch (IllegalArgumentException e) {
			throw criarSoapFault("ERRO_DE_VALIDACAO", e.getMessage());
		} catch (SQLException e) {
			throw criarSoapFault("ERRO_SQL", "Erro ao acessar o banco de dados.");
		} catch (Exception e) {
			throw criarSoapFault("ERRO_INTERNO", "Ocorreu um erro interno inesperado.");
		} finally {
			// Fecha o PreparedStatement para evitar vazamento de recursos
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					logger.warning("Erro ao fechar o PreparedStatement: " + e.getMessage());
				}
			}
		}
		return id;
	}



	@Override
	public Produto alterar(Produto produto) throws SQLException {
		validarProduto(produto);
		PreparedStatement stmt = null;
		try{
			String sql = "update produto set nome = ? , quantidade = ? , preco_unitario = ? , data_cadastro = ? "
					+ "where id = ? ;";
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setInt(2, produto.getQuantidade());
			stmt.setDouble(3, produto.getPreco());
			stmt.setDate(4, new Date(produto.getData().getTime()));
			stmt.setLong(5, produto.getId());
			stmt.execute();
			return ler(produto.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return null;
	}

	@Override
	public boolean apagar(Long id) throws SQLException {
		PreparedStatement stmt = null;
		try{
			String sql = "delete from produto where id = ? ;";
			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return false;
	}

	@Override
	public List<Produto> listar() throws SQLException {
		ArrayList<Produto> produtos = new ArrayList<>();
		Statement stmt = null;
		try {
			String sql = "select * from produto";
			stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Produto prod = new Produto();
				prod.setId(rs.getLong("id"));
				prod.setNome(rs.getString("nome"));
				prod.setQuantidade((rs.getInt("quantidade")));
				prod.setPreco(rs.getDouble("preco_unitario"));
				prod.setData(new java.util.Date(rs.getDate("data_cadastro").getTime()));
				produtos.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return produtos;
	}

	@Override
	public Produto ler(long id) throws SQLException {
		Statement stmt = null;
		Produto prod = null;
		try{
			String sql = "select * from produto where id = " + id;
			stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				prod = new Produto();
				prod.setId(rs.getLong("id"));
				prod.setNome(rs.getString("nome"));
				prod.setQuantidade((rs.getInt("quantidade")));
				prod.setPreco(rs.getDouble("preco_unitario"));
				prod.setData(new java.util.Date(rs.getDate("data_cadastro").getTime()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return prod;
	}

	private void validarProduto(Produto produto) {
		if (produto == null) {
			throw new IllegalArgumentException("O produto nao pode ser nulo.");
		}
		if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
			throw new IllegalArgumentException("O nome do produto é obrigatorio.");
		}
		if (produto.getQuantidade() < 0 || produto.getQuantidade() == null) {
			throw new IllegalArgumentException("A quantidade nao pode ser negativa ou nula.");
		}
		if (produto.getPreco() < 0 || produto.getPreco() == null) {
			throw new IllegalArgumentException("O preco unitario nao pode ser negativo ou nulo.");
		}
	}

	private SOAPFaultException criarSoapFault(String codigo, String mensagem) {
		try {
			SOAPFault fault = SOAPFactory.newInstance().createFault();
			fault.setFaultCode(codigo);
			fault.setFaultString(mensagem);
			return new SOAPFaultException(fault);
		} catch (SOAPException e) {
			throw new RuntimeException("Erro ao criar SOAPFault.", e);
		}
	}



}
