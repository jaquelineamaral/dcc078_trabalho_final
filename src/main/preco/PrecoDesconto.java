package main.preco;

public class PrecoDesconto implements Precificacao {

    private float desconto;

    public PrecoDesconto(float desconto) {
        this.desconto = desconto;
    }

    @Override
    public float calcularPreco(float precoBase) {
        return precoBase * (1 - desconto);
    }

}



