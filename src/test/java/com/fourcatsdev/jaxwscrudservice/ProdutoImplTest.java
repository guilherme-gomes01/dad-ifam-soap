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
    private Connection mockConnection;

    @Before
    public void setUp() {
        mockConnection = Conexao.getConnection();
        produtoDao = new ProdutoImpl(mockConnection);
    }

    @Test
    public void testAdicionarProdutoInexistente() {
        Produto produto = new Produto();
        produto.setNome(null);
        assertThrows(SQLException.class, () -> produtoDao.adicionar(produto));
    }

    @Test
    public void testAtualizarComValoresInvalidos() {
        Produto produto = new Produto();
        produto.setId(3);
        produto.setPreco(-10);

        Exception exception = assertThrows(IllegalAccessException.class, () -> produtoDao.alterar(produto));
        assertEquals("Preco nao pode ser negativo", exception.getMessage());
    }

}
