package main.pedido;

import main.notificacao.Cliente;
import main.produto.Produto;

import java.util.ArrayList;
import java.util.List;


public class Pedido {

    private Cliente cliente;
    private Produto produto;
    private EstadoPedido estado;
    private List<EstadoPedido> memento = new ArrayList<EstadoPedido>();


    public Pedido(Cliente cliente, Produto produto) {
        this.cliente = cliente;
        this.produto = produto;
        this.estado = new Recebido();
        this.memento.add(this.estado);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<EstadoPedido> getEstados() {
        return memento;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void avancarEstado() {
        this.estado = estado.proximoEstado();
        this.memento.add(this.estado);
    }

    public String mostrarEstado() {
        return "Estado atual: " + estado.getEstado();
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.estado = this.memento.get(indice);
    }
}
