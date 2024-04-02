package minhacalculadora;

import operacoes.*;
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
    final int[]  valoresDosTermos = {0, 0};
    int          modulo;

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

    public void mostrarResultado() { System.out.printf("%s = %d\n", this.resultado, this.getCalculo()); }

    private int getCalculo() {
        switch (this) {
            case ADICAO:        return new Adicao(valoresDosTermos[0], valoresDosTermos[1]).getSoma();
            case SUBTRACAO:     return new Subtracao(valoresDosTermos[0], valoresDosTermos[1]).getResto();
            case MULTIPLICACAO: return new Multiplicacao(valoresDosTermos[0], valoresDosTermos[1]).getProduto();
            default:
                Divisao divisao = new Divisao(valoresDosTermos[0], valoresDosTermos[1]);
                modulo = divisao.getModulo();
                return divisao.getQuociente();
        }
    }

    public void mostrarResto() {
        if (this.equals(Operacao.DIVISAO) && modulo != 0) System.out.printf("Resto = %d\n", modulo);
    }
}