package main.produto;


public class Eletronico extends Produto {

    public Eletronico(String nome, float preco) {
        super(nome, preco);
    }

    public Eletronico(){}

    @Override
    public String getCategoria() {
        return "Eletronico";
    }

}
