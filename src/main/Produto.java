package main;


public abstract class Produto {

    String nome;
    float preco;


    public Produto(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(){}

    public float getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getCategoria();
}
