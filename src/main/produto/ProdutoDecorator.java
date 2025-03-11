package main.produto;

public abstract class ProdutoDecorator extends Produto {

    protected Produto produto;

    public ProdutoDecorator(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String getNome() {
        return produto.getNome();
    }

    @Override
    public float getPreco() {
        return produto.getPreco();
    }

    @Override
    public String getCategoria() {
        return produto.getCategoria();
    }
}
