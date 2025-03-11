package test;

import main.notificacao.Cliente;
import main.pedido.Pedido;
import main.produto.Produto;
import main.produto.ProdutoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StateTest {

    Pedido pedido;

    @BeforeEach
    public void before() {
        Cliente cliente = new Cliente("João", "joao@gmail.com");

        Produto produto = ProdutoFactory.criarProduto("Roupa");
        produto.setNome("Blusa");
        produto.setPreco(50.00F);

        pedido = new Pedido(cliente, produto);
    }

    @Test
    public void deveRegistrarPedidoComEstadoRecebido() {
        assertEquals("Estado atual: Recebido", pedido.mostrarEstado());
    }

    @Test
    public void deveAlterarEstadoDoPedidoParaProcessando() {
        pedido.avancarEstado();
        assertEquals("Estado atual: Processando", pedido.mostrarEstado());
    }

    @Test
    public void deveAlterarEstadoDoPedidoParaEnviado() {
        pedido.avancarEstado();
        pedido.avancarEstado();
        assertEquals("Estado atual: Enviado", pedido.mostrarEstado());
    }

    @Test
    public void deveAlterarEstadoDoPedidoParaEntregue() {
        pedido.avancarEstado();
        pedido.avancarEstado();
        pedido.avancarEstado();
        assertEquals("Estado atual: Entregue", pedido.mostrarEstado());
    }

}
