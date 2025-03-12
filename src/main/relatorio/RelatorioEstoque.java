package main.relatorio;

import main.produto.Estoque;
import main.produto.Produto;

import java.util.HashMap;
import java.util.Map;


public abstract class RelatorioEstoque {

    private String dados;

    public final String gerarRelatorio() {
        coletarDados();
        return exportar(dados);
    }

    private void coletarDados() {
        Map<Produto, Integer> map = new HashMap<>();
        map = Estoque.getInstancia().getProdutos();

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Produto, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey().getNome()).append(": ").append(entry.getValue()).append("\n");
        }

        this.dados = sb.toString();
    }

    protected abstract String exportar(String dados);
}
