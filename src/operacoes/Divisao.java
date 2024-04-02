package operacoes;

public class Divisao extends Calcular {
    int modulo = 0;

    public Divisao(int... valoresDosTermos) {
        resultado = valoresDosTermos[0];;
        for (int i = 1; i < valoresDosTermos.length; i++) {
            modulo += resultado % valoresDosTermos[i];
            resultado /= valoresDosTermos[i];
        }
    }

    public int getModulo() { return modulo; }
}