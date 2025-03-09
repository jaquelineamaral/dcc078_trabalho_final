package main.pedido;

public class Pedido {

    private EstadoPedido estado;

    public Pedido() {
        this.estado = new Recebido();
    }

    public void avancarEstado() {
        this.estado = estado.proximoEstado();
    }

    public String mostrarEstado() {
        return "Estado atual: " + estado.getEstado();
    }

}
