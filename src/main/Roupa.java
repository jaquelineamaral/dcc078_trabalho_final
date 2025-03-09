package main;


public class Roupa extends Produto{

    public Roupa(String nome, float preco) {
        super(nome, preco);
    }

    public Roupa() {
        super();
    }

    @Override
    public String getCategoria() {
        return "Roupa";
    }

}
