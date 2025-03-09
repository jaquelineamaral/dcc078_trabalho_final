package main.pedido;

public interface EstadoPedido {

    EstadoPedido proximoEstado();
    String getEstado();

}
