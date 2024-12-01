package com.fourcatsdev.jaxwscrudservice;

import com.fourcatsdev.jaxwscrudservice.dao.ProdutoImpl;
import com.fourcatsdev.jaxwscrudservice.modelo.Produto;
import com.fourcatsdev.jaxwscrudservice.util.Conexao;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ProdutoImplTest {

    private ProdutoImpl produtoDao;
    private Connection Connection;

    @Before
    public void setUp() {
        Connection = Conexao.getConnection();
        produtoDao = new ProdutoImpl(Connection);
    }

    @Test
    public void testAdicionarProdutoInexistente() {
        Produto produto = new Produto();
        produto.setNome(null);
        assertThrows(SQLException.class, () -> produtoDao.adicionar(produto));
    }

    @Test
    public void testAlterarComValoresInvalidos() {
        Produto produto = new Produto();
        produto.setId(3);
        produto.setPreco(-10);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> produtoDao.alterar(produto));
        assertEquals("Preço não pode ser negativo.", exception.getMessage());
    }

}
