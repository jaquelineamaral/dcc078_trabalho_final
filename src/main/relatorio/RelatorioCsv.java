package main.relatorio;

public class RelatorioCsv extends RelatorioEstoque {

    @Override
    protected String exportar(String dados) {
        return "Gerando CSV... \n" + dados;
    }
}
