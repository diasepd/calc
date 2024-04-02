package operacoes;

public class Multiplicacao extends Calcular {
    public Multiplicacao(int... valoresDosTermos) {
        resultado = valoresDosTermos[0];;
        for (int i = 1; i < valoresDosTermos.length; i++) { resultado *= valoresDosTermos[i]; }
    }
}