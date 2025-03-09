package test;

import main.Produto;
import main.ProdutoFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class FactoryMethodTest {

    @Test
    void deveRetornarExcecaoParaCategoriaProdutoNaoCadastrado() {
        try {
            Produto produto = ProdutoFactory.criarProduto("Eletrodomestico");
            produto.setNome("TesteFactoryMethod");
            produto.setPreco(3.00F);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Categoria de produto não cadastrada", e.getMessage());
        }
    }

    /*
    @Test
    void deveRetornarExcecaoParaCategoriaProdutoInvalida() {
        try {
            Produto produto = ProdutoFactory.criarProduto("Estoque");
            produto.setNome("TesteFactoryMethod");
            produto.setPreco(3.00F);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Categoria de produto inválida", e.getMessage());
        }
    }
    */

    @Test
    void deveRetornarCategoriaRoupa() {
        Produto produto = ProdutoFactory.criarProduto("Roupa");
        assertEquals("Roupa", produto.getCategoria());
    }

    @Test
    void deveRetornarCategoriaEletronico() {
        Produto produto = ProdutoFactory.criarProduto("Eletronico");
        assertEquals("Eletronico", produto.getCategoria());
    }

}
