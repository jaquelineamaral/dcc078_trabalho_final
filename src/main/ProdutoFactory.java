package main;


public class ProdutoFactory {

    public static Produto criarProduto(String categoriaProduto) {
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("src.main." + categoriaProduto);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Categoria de produto não cadastrada");
        }
        if (!(objeto instanceof Produto)) {
            throw new IllegalArgumentException("Categoria de produto inválida");
        }
        return (Produto) objeto;
    }

}
