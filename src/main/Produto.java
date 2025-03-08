package main;


public abstract class Produto {

    String nome;
    float preco;


    public Produto(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public abstract String getCategoria();
    public abstract void setNome(String nome);
    public abstract void setPreco(float preco);
}
