import Operacoes.*;
import java.util.Scanner;

public enum Operacao {
    ADICAO       ("+"              , "1ª parcela"       , "2ª parcela"   , "Soma"     ),
    SUBTRACAO    ("-"              , "Minuendo"         , "Subtraendo"   , "Resto"    ),
    MULTIPLICACAO("*"              , "Multiplicando"    , "Multiplicador", "Produto"  ),
    DIVISAO      ("/"              , "Dividendo"        , "Divisor"      , "Quociente"),
    SAIR         ("S"              , ""                 , ""             , ""         ),
    OPCAOINVALIDA("Opção inválida!", "Divisor inválido!", ""             , ""         );

    final String descricao;
    final String primeiroTermo;
    final String segundoTermo;
    final String resultado;
    final int[]  valoresDosTermos = {0, 0, 0};

    Operacao(String descricao, String primeiroTermo, String segundoTermo, String resultado) {
        this.descricao     = descricao;
        this.primeiroTermo = primeiroTermo;
        this.segundoTermo  = segundoTermo;
        this.resultado     = resultado;
    }

    public boolean EhValida() {
        if (this.equals(Operacao.OPCAOINVALIDA)) {
            System.out.println(this.descricao);
            return false;
        } else return !this.equals(Operacao.SAIR);
    }

    public void digitarTermos(Scanner scanner) {
        for (int i = 0; i < 2; i++) {
            System.out.printf("%s: ", i == 0 ? this.primeiroTermo : this.segundoTermo);
            this.valoresDosTermos[i] = scanner.nextInt();
        }
    }

    public boolean naoEhDivisaoInvalida() {
        if (!(this.equals(Operacao.DIVISAO) && this.valoresDosTermos[1] == 0)) return true;
        System.out.println(Operacao.OPCAOINVALIDA.primeiroTermo);
        return false;
    }

    public void mostrarResultado() {System.out.printf("%s = %d\n", this.resultado, this.getCalculo());}

    private int getCalculo() {
        switch (this) {
            case ADICAO:        return Somar.soma(valoresDosTermos);
            case SUBTRACAO:     return Subtrair.resto(valoresDosTermos);
            case MULTIPLICACAO: return Multiplicar.produto(valoresDosTermos);
            default:            valoresDosTermos[2] = Dividir.modulo(valoresDosTermos);
                                return Dividir.quociente(valoresDosTermos);
        }
    }

    public void mostrarResto() {
        if (this.equals(Operacao.DIVISAO) && restoDeDivisao())
            System.out.printf("Resto = %d\n", this.valoresDosTermos[2]);}

    private boolean restoDeDivisao() {return this.valoresDosTermos[2] != 0;}
}