package operacoes;

public class Divisao extends Calcular {
    int mod = 0;

    public int getMod() { return mod; }

    @Override
    public int calcular(int... valoresDosTermos) {
        resultado = valoresDosTermos[0];;
        for (int i = 1; i < valoresDosTermos.length; i++) {
            mod += resultado % valoresDosTermos[i];
            resultado /= valoresDosTermos[i];
        }
        return resultado;
    }
}