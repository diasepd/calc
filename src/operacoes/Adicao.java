package operacoes;

public class Adicao extends Calcular{
    public Adicao(int... valoresDosTermos) { for (int termo: valoresDosTermos) resultado += termo; }
}