package test;

import main.preco.GarantiaEstendidaDecorator;
import main.produto.Produto;
import main.produto.ProdutoFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DecoratorTest {

    @Test
    void testGarantiaEstendidaAdicionada() {

        Produto celular = ProdutoFactory.criarProduto("Eletronico");
        celular.setNome("Samsung");
        celular.setPreco(2000F);

        assertEquals(2000, celular.getPreco(), 0.01);
        assertEquals("Eletronico", celular.getCategoria());

        celular = new GarantiaEstendidaDecorator(celular, 500);
        assertEquals(2500, celular.getPreco(), 0.01);
        assertEquals("Eletronico com garantia estendida", celular.getCategoria());
    }

    @Test
    void testGarantiaComDiferentesValores() {
        Produto tv = ProdutoFactory.criarProduto("Eletronico");
        tv.setNome("Smart TV");
        tv.setPreco(3000F);

        Produto tvGarantia100 = new GarantiaEstendidaDecorator(tv, 100);
        assertEquals(3100, tvGarantia100.getPreco(), 0.01);
        assertEquals("Eletronico com garantia estendida", tvGarantia100.getCategoria());

        Produto tvGarantia500 = new GarantiaEstendidaDecorator(tv, 500);
        assertEquals(3500, tvGarantia500.getPreco(), 0.01);
        assertEquals("Eletronico com garantia estendida", tvGarantia500.getCategoria());
    }

    @Test
    void testGarantiaComMultiplosDecorators() {
        Produto geladeira = ProdutoFactory.criarProduto("Eletronico");
        geladeira.setNome("Geladeira");
        geladeira.setPreco(4000F);

        Produto geladeiraGarantia1 = new GarantiaEstendidaDecorator(geladeira, 400);
        Produto geladeiraGarantia2 = new GarantiaEstendidaDecorator(geladeiraGarantia1, 200);

        assertEquals(4600, geladeiraGarantia2.getPreco(), 0.01);
        assertEquals("Eletronico com garantia estendida com garantia estendida", geladeiraGarantia2.getCategoria());
    }


}
