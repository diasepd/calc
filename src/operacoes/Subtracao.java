package operacoes;

public class Subtracao {
    int resto;

    public Subtracao(int... valoresDosTermos) {
        resto = valoresDosTermos[0];
        for (int i = 1; i < valoresDosTermos.length; i++) { resto -= valoresDosTermos[i]; }
    }

    public int getResto() { return resto; }
}