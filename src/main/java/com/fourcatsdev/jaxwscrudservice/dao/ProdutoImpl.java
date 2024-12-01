package com.fourcatsdev.jaxwscrudservice.dao;

import com.fourcatsdev.jaxwscrudservice.modelo.Produto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProdutoImpl implements ProdutoDao{

	private Connection connection;

	public ProdutoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public long adicionar(Produto produto) throws SQLException {
		if (produto == null || produto.getNome() == null || produto.getNome().isEmpty()) {
			throw new SQLException("Produto inválido: O nome é obrigatório.");
		}
		if(produto.getPreco() < 0) {
			throw new IllegalArgumentException("Somente valores positivos sao aceitos para preço");
		}
		if(produto.getQuantidade() < 0) {
			throw new IllegalArgumentException("Somente valores positivos sao aceitos para quantidade");
		}
		Statement stmt = null;
		long id = 0;
		try{
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String datahora = sdf.format(produto.getData());
			String sql = "insert into produto (nome, quantidade, preco_unitario, data_cadastro)"
					+ " values (\'"+produto.getNome()+"\',\'"+produto.getQuantidade()+"\',\'"+produto.getPreco()+"\',\'"+ datahora +"\') RETURNING ID";
			stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				id = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return id;
	}

	@Override
	public Produto alterar(Produto produto) throws SQLException {
		if (produto == null || produto.getId() <= 0) {
			throw new IllegalArgumentException("Produto inválido: ID deve ser positivo.");
		}
		if (produto.getPreco() < 0) {
			throw new IllegalArgumentException("Preço não pode ser negativo.");
		}
		if(produto.getQuantidade() < 0) {
			throw new IllegalArgumentException("Quantidade de produtos não pode ser negativa.");
		}
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
		ArrayList<Produto> produtos = new ArrayList<Produto>();
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
}
