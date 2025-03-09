package test;

import main.preco.PrecoDesconto;
import main.preco.PrecoFixo;
import main.produto.Estoque;
import main.produto.Produto;
import main.produto.ProdutoFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StrategyTest {

    @Test
    void calcularPrecoComDesconto () {
        Produto produto = ProdutoFactory.criarProduto("Roupa");
        produto.setNome("Blusa");
        produto.setPreco(50.00F);

        Estoque estoque = Estoque.getInstancia();
        estoque.adicionarProduto(produto.getNome(), 3);

        PrecoDesconto desconto = new PrecoDesconto(0.3F);

        assertEquals(35, desconto.calcularPreco(produto.getPreco()));
    }

    @Test
    void calcularPrecoFixo () {
        Produto produto = ProdutoFactory.criarProduto("Eletronico");
        produto.setNome("Celular");
        produto.setPreco(2000F);

        Estoque estoque = Estoque.getInstancia();
        estoque.adicionarProduto(produto.getNome(), 1);

        PrecoFixo desconto = new PrecoFixo();

        assertEquals(2000, desconto.calcularPreco(produto.getPreco()));
    }

}
