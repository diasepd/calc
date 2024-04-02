package operacoes;

public class Adicao {
    int soma = 0;

    public Adicao(int... valoresDosTermos) { for (int termo: valoresDosTermos) soma += termo; }

    public int getSoma() { return soma; }
}