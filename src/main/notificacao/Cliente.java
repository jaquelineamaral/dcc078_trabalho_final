package main.notificacao;

import main.produto.Estoque;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;


public class Cliente implements Observer {

    private String nome;
    private String email;
    private String notificacao;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(String notificacao) {
        this.notificacao = notificacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.notificacao = nome + " confira nossos novos produtos disponíveis!";
    }

    public void notificar(Estoque estoque) {
        estoque.addObserver(this);
    }
}
