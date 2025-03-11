package main.preco;

import main.produto.Produto;
import main.produto.ProdutoDecorator;

public class GarantiaEstendidaDecorator extends ProdutoDecorator {

    private float valorGarantia;

    public GarantiaEstendidaDecorator(Produto produto, float valorGarantia) {
        super(produto);
        this.valorGarantia = valorGarantia;
    }

    @Override
    public float getPreco() {
        return produto.getPreco() + valorGarantia;
    }

    @Override
    public String getCategoria() {
        return produto.getCategoria() + " com garantia estendida";
    }
}
