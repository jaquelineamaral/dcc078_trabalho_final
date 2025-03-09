package test;

import main.pedido.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StateTest {

    Pedido pedido;

    @BeforeEach
    public void before() {
        pedido = new Pedido();
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
