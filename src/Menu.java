import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operacao operacao;
        do {menuComOperacoes();
            operacao = escolherOperacao(scanner.next());
            if (operacao.EhValida()) {
                operacao.digitarTermos(scanner);
                if (operacao.naoEhDivisaoInvalida()) {
                    operacao.mostrarResultado();
                    operacao.mostrarResto();
                }
            }
        } while (operacao != Operacao.SAIR);
    }

    static void menuComOperacoes() {
        System.out.printf("\nEscolha uma operação matemática: %s %s %s %s ou S (Sair): ", Operacao.ADICAO.descricao,
                Operacao.SUBTRACAO.descricao, Operacao.MULTIPLICACAO.descricao, Operacao.DIVISAO.descricao);
    }

    static Operacao escolherOperacao(String texto) {
        for (Operacao operacao: Operacao.values()) {if (texto.toUpperCase().equals(operacao.descricao)) return operacao;}
        return Operacao.OPCAOINVALIDA;
    }
}