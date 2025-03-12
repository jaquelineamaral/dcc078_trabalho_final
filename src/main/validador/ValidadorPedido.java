package main.validador;

import main.pedido.Pedido;


public abstract class ValidadorPedido {

    private ValidadorPedido proximoValidador;

    public ValidadorPedido getProximoValidador() {
        return proximoValidador;
    }

    public void setProximoValidador(ValidadorPedido proximoValidador) {
        this.proximoValidador = proximoValidador;
    }

    public abstract String validar(Pedido pedido);
    public String processar(Pedido pedido) {
        String resultado = validar(pedido);

        if (proximoValidador != null && !(resultado.contains("Erro"))) {
            return proximoValidador.processar(pedido);
        }

        return resultado;
    }

}
