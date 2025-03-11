package test;

import main.notificacao.Cliente;
import main.pedido.Pedido;
import main.produto.Produto;
import main.produto.ProdutoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MementoTest {

    Cliente cliente;
    Produto produto;
    Pedido pedido;

    @BeforeEach
    public void before() {
        cliente = new Cliente("João", "joao@gmail.com");

        produto = ProdutoFactory.criarProduto("Roupa");
        produto.setNome("Blusa");
        produto.setPreco(50.00F);

        pedido = new Pedido(cliente, produto);
    }

    @Test
    void deveArmazenarEstados() {
        pedido.avancarEstado();
        pedido.avancarEstado();
        assertEquals(3, pedido.getEstados().size());
    }

   @Test
    void deveRetornarEstadoInicial() {
       pedido.avancarEstado();
       pedido.avancarEstado();
       pedido.restauraEstado(0);
       assertEquals("Estado atual: Recebido", pedido.mostrarEstado());
    }


    @Test
    void deveRetornarEstadoAnterior() {
        pedido.avancarEstado();
        pedido.avancarEstado();
        pedido.avancarEstado();
        pedido.restauraEstado(2);
        assertEquals("Estado atual: Enviado", pedido.mostrarEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            pedido.restauraEstado(4);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}
