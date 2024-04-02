package operacoes;

public class Multiplicacao {
    int produto;

    public Multiplicacao(int... valoresDosTermos) {
        produto = valoresDosTermos[0];;
        for (int i = 1; i < valoresDosTermos.length; i++) { produto *= valoresDosTermos[i]; }
    }

    public int getProduto() { return produto; }
}