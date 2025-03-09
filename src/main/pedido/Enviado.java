package main.pedido;

public class Enviado implements EstadoPedido {

    @Override
    public EstadoPedido proximoEstado() {
        return new Entregue();
    }

    @Override
    public String getEstado() {
        return "Enviado";
    }
}
