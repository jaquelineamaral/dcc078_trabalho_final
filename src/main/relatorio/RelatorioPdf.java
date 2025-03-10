package main.relatorio;

public class RelatorioPdf extends RelatorioEstoque {

    @Override
    protected String exportar(String dados) {
        return "Gerando PDF... \n" + dados;
    }
}
