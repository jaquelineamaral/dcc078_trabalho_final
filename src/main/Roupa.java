package main;


public class Roupa extends Produto{

    public Roupa(String nome, float preco) {
        super(nome, preco);
    }

    @Override
    public String getCategoria() {
        return "Roupa";
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
