package main.validador;

import main.pedido.Pedido;

public class ValidadorEntrega extends ValidadorPedido {

    private boolean entregaDisponivel;

    public ValidadorEntrega(boolean entregaDisponivel) {
        this.entregaDisponivel = entregaDisponivel;
    }

    @Override
    public String validar(Pedido pedido) {

        if (entregaDisponivel) {
            return "Entrega disponível.";
        } else {
            return "Erro: Entrega não disponível para esta região.";
        }
    }
}
