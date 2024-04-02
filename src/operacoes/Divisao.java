package operacoes;

public class Divisao {
    int modulo;
    int quociente;

    public Divisao(int... valoresDosTermos) {
        modulo = 0;
        quociente = valoresDosTermos[0];;
        for (int i = 1; i < valoresDosTermos.length; i++) {
            modulo += quociente % valoresDosTermos[i];
            quociente /= valoresDosTermos[i];
        }
    }

    public int getModulo()    { return modulo; }
    public int getQuociente() { return quociente; }
}