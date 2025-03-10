package main.produto;


public class ProdutoFactory {

    static Class<?> classe;
    static Object objeto;

    public static Produto criarProduto(String categoriaProduto) {

        try {
            classe = Class.forName("main.produto." + categoriaProduto);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Categoria de produto não cadastrada");
        }
        if (!(objeto instanceof Produto)) {
            throw new IllegalArgumentException("Categoria de produto inválida");
        }
        return (Produto) objeto;
    }

}
