package main.validador;

import main.pedido.Pedido;

public class ValidadorPagamento extends ValidadorPedido {

    private boolean pagamentoAprovado;

    public ValidadorPagamento(boolean pagamentoAprovado) {
        this.pagamentoAprovado = pagamentoAprovado;
    }

    @Override
    public String validar(Pedido pedido) {

        if (pagamentoAprovado) {
            return "Pagamento aprovado.";
        } else {
            return "Erro: Pagamento recusado.";
        }
    }
}
