package main.validador;

import main.pedido.Pedido;
import main.produto.Estoque;

public class ValidadorEstoque extends ValidadorPedido {

    @Override
    public String validar(Pedido pedido) {

        Estoque estoque = Estoque.getInstancia();
        int quantidadeDisponivel = estoque.getQuantidade(pedido.getProduto());

        if (quantidadeDisponivel >= 1) {
            return "Produto disponível.";
        } else {
            return "Erro: Produto fora de estoque.";
        }
    }


}
