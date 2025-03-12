package main.produto;

import java.util.*;


public class Estoque extends Observable {

    private static Estoque instancia;
    private Map<Produto, Integer> produtos = new HashMap<>();


    private Estoque() {}


    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.put(produto, produtos.getOrDefault(produto, 0) + quantidade); //retornar 0 se o produto nao estiver no dicionario
        setChanged();
        notifyObservers();
    }

    public int getQuantidade(Produto produto) {
        return produtos.getOrDefault(produto, 0);
    }

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }

}
