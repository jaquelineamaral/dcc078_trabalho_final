import java.util.HashMap;
import java.util.Map;


public class Estoque {

    private static Estoque instancia;
    private Map<String, Integer> produtos = new HashMap<>();


    private Estoque() {}


    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public void adicionarProduto(String nomeProduto, int quantidade) {
        produtos.put(nomeProduto, produtos.getOrDefault(nomeProduto, 0) + quantidade); //retornar 0 se o produto nao estiver no dicionario
    }

    public boolean removerProduto(String nomeProduto, int quantidade) {
        //se a quant de produtos que tenho em estoque for maior que a quant que quero remover, subtraio
        if(produtos.getOrDefault(nomeProduto, 0) > quantidade) {
            produtos.put(nomeProduto, produtos.get(nomeProduto) - quantidade);
            return true;
        }

        return false;
    }

    public int getQuantidade(String nomeProduto) {
        return produtos.getOrDefault(nomeProduto, 0);
    }
}
