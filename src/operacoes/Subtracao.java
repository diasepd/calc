package operacoes;

public class Subtracao extends Calculo {
    @Override
    public int calcular(int... valoresDosTermos){
        resultado = valoresDosTermos[0];
        for(int i = 1; i < valoresDosTermos.length; i++)
            resultado -= valoresDosTermos[i];
        return resultado;
    }
}