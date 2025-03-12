package test;

import main.produto.Estoque;
import main.produto.Produto;
import main.produto.ProdutoFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SingletonTest {

    @Test
    public void retornaUmProdutoCadastrado() {
        Produto produto = ProdutoFactory.criarProduto("Roupa");
        produto.setNome("Calça");
        produto.setPreco(100F);

        Estoque.getInstancia().adicionarProduto(produto, 1);
        assertEquals(1, Estoque.getInstancia().getQuantidade(produto));
    }

}
