package operacoes;

public class Adicao extends Calcular{
    @Override
    public int calcular(int... valoresDosTermos) {
        for (int termo: valoresDosTermos) resultado += termo;
        return resultado;
    }
}