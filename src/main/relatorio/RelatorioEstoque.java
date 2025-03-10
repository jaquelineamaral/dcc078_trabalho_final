package main.relatorio;

import main.produto.Estoque;

import java.util.HashMap;
import java.util.Map;


public abstract class RelatorioEstoque {

    private String dados;

    public final String gerarRelatorio() {
        coletarDados();
        return exportar(dados);
    }

    private void coletarDados() {
        Map<String, Integer> map = new HashMap<>();
        map = Estoque.getInstancia().getProdutos();

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            System.out.println("1");
        }

        this.dados = sb.toString();
    }

    protected abstract String exportar(String dados);
}
