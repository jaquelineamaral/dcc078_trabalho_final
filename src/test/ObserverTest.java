package test;

import main.notificacao.Cliente;
import main.produto.Estoque;
import main.produto.Produto;
import main.produto.ProdutoFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ObserverTest {

    @Test
    public void deveNotificarClientes() {
        Cliente cliente1 = new Cliente("João", "joao@gmail.com");
        Cliente cliente2 = new Cliente("Maria", "maria@gmail.com");

        cliente1.notificar(Estoque.getInstancia());
        cliente2.notificar(Estoque.getInstancia());

        Produto produto = ProdutoFactory.criarProduto("Roupa");
        produto.setNome("Calça");
        produto.setPreco(100F);
        Estoque.getInstancia().adicionarProduto(produto, 20);

        assertEquals("João confira nossos novos produtos disponíveis!", cliente1.getNotificacao());
        assertEquals("Maria confira nossos novos produtos disponíveis!", cliente2.getNotificacao());
    }
}
