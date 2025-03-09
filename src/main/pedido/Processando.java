package main.pedido;

public class Processando implements EstadoPedido {

    @Override
    public EstadoPedido proximoEstado() {
        return new Enviado();
    }

    @Override
    public String getEstado() {
        return "Processando";
    }
}
