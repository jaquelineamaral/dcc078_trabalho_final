package main;


public class Eletronico extends Produto{

    public Eletronico(String nome, float preco) {
        super(nome, preco);
    }

    @Override
    public String getCategoria() {
        return "Eletronico";
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
