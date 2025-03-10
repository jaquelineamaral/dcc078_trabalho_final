package test;

import main.produto.Estoque;
import main.produto.Produto;
import main.produto.ProdutoFactory;
import main.relatorio.RelatorioCsv;
import main.relatorio.RelatorioEstoque;
import main.relatorio.RelatorioPdf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TemplateMethodTest {

    //se todos os testes forem executados ao mesmo tempo, resultado será diferente

    @Test
    void deveRetornarRelatórioEmPdf () {
        Produto produto = ProdutoFactory.criarProduto("Eletronico");
        produto.setNome("Celular");
        produto.setPreco(2000F);

        Estoque estoque = Estoque.getInstancia();
        estoque.adicionarProduto(produto.getNome(), 3);

        RelatorioEstoque relatorioEstoque = new RelatorioPdf();

        String esperado = "Gerando PDF... \n" + "Celular: 3\n";

        assertEquals(esperado, relatorioEstoque.gerarRelatorio());
    }

    @Test
    void deveRetornarRelatórioEmCsv () {
        Produto produto1 = ProdutoFactory.criarProduto("Roupa");
        Produto produto2 = ProdutoFactory.criarProduto("Eletronico");
        produto1.setNome("Blusa");
        produto1.setPreco(70F);
        produto2.setNome("Jaqueta");
        produto2.setPreco(180F);

        Estoque estoque = Estoque.getInstancia();
        estoque.adicionarProduto(produto1.getNome(), 3);
        estoque.adicionarProduto(produto2.getNome(), 7);

        RelatorioEstoque relatorioEstoque = new RelatorioCsv();

        String esperado = "Gerando CSV... \n" +
                "Jaqueta: 7\n" +
                "Blusa: 3\n";

        assertEquals(esperado, relatorioEstoque.gerarRelatorio());
    }
}
