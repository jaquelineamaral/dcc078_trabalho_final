package main;

public class PrecoFixo implements Precificacao{

    @Override
    public float calcularPreco(float precoBase) {
        return precoBase;
    }

}
