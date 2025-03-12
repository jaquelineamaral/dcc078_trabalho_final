package test;

import main.notificacao.Cliente;
import main.pedido.Pedido;
import main.produto.Eletronico;
import main.produto.Estoque;
import main.produto.Produto;
import main.produto.ProdutoFactory;
import main.validador.ValidadorEntrega;
import main.validador.ValidadorEstoque;
import main.validador.ValidadorPagamento;
import main.validador.ValidadorPedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ChainOfResponsabilityTest {

    Cliente cliente;
    Produto produto;
    Pedido pedido;
    ValidadorPedido validador;
    ValidadorPedido validadorEntrega;
    ValidadorPedido validadorPagamento;


    @BeforeEach
    public void before() {
        cliente = new Cliente("João", "joao@gmail.com");

        produto = ProdutoFactory.criarProduto("Roupa");
        produto.setNome("Blusa");
        produto.setPreco(50.00F);

        pedido = new Pedido(cliente, produto);
    }

    @Test
    void pedidoSucesso() {
        validador = new ValidadorEstoque();
        validadorEntrega = new ValidadorEntrega(true);
        validadorPagamento = new ValidadorPagamento(true);

        validador.setProximoValidador(validadorEntrega);
        validadorEntrega.setProximoValidador(validadorPagamento);

        Estoque estoque = Estoque.getInstancia();
        estoque.adicionarProduto(produto.getNome(), 5);

        assertEquals("Pagamento aprovado.", validador.processar(pedido));
    }

    @Test
    void pedidoSemEstoque() {

        validador = new ValidadorEstoque();
        validadorEntrega = new ValidadorEntrega(true);
        validadorPagamento = new ValidadorPagamento(true);

        validador.setProximoValidador(validadorEntrega);
        validadorEntrega.setProximoValidador(validadorPagamento);

        Estoque estoque = Estoque.getInstancia();
        estoque.getProdutos().clear();

        assertEquals("Erro: Produto fora de estoque.", validador.processar(pedido));
    }

    @Test
    void entregaNaoDisponivel() {
        validador = new ValidadorEstoque();
        validadorEntrega = new ValidadorEntrega(false);
        validadorPagamento = new ValidadorPagamento(true);

        validador.setProximoValidador(validadorEntrega);
        validadorEntrega.setProximoValidador(validadorPagamento);

        Estoque estoque = Estoque.getInstancia();
        estoque.adicionarProduto(produto.getNome(), 5);

        assertEquals("Erro: Entrega não disponível para esta região.", validador.processar(pedido));
    }

    @Test
    void pagamentoRecusado() {
        validador = new ValidadorEstoque();
        validadorEntrega = new ValidadorEntrega(true);
        validadorPagamento = new ValidadorPagamento(false);

        validador.setProximoValidador(validadorEntrega);
        validadorEntrega.setProximoValidador(validadorPagamento);

        Estoque estoque = Estoque.getInstancia();
        estoque.adicionarProduto(produto.getNome(), 5);

        assertEquals("Erro: Pagamento recusado.", validador.processar(pedido));
    }
}
