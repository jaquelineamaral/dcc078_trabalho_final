package test;

import main.Estoque;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SingletonTest {

    @Test
    public void retornaUmProdutoCadastrado() {
        Estoque.getInstancia().adicionarProduto("ProdutoTesteSingleton", 1);
        assertEquals(1, Estoque.getInstancia().getQuantidade("ProdutoTesteSingleton"));
    }

}
