package main.pedido;

public class Entregue implements EstadoPedido {

    @Override
    public EstadoPedido proximoEstado() {
        return this;
    }

    @Override
    public String getEstado() {
        return "Entregue";
    }
}
