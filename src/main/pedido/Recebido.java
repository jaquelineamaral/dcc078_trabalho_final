package main.pedido;

public class Recebido implements EstadoPedido {

    @Override
    public EstadoPedido proximoEstado() {
        return new Processando();
    }

    @Override
    public String getEstado() {
        return "Recebido";
    }
}
