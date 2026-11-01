package financeiro;

import java.util.HashSet;
import java.util.Set;

public class Caixa {

    private final Set<Transacao> transacoes = new HashSet<>();
    private double totalSaidas;
    private double totalGorjetas;

    public boolean registrarTransacao(Transacao transacao) {
        return transacoes.add(transacao);
    }

    public void registrarSaida(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "O valor da saída deve ser positivo."
            );
        }

        totalSaidas += valor;
    }

    public void registrarGorjeta(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException(
                    "O valor da gorjeta não pode ser negativo."
            );
        }

        totalGorjetas += valor;
    }

    public double calcularTotalEntradas() {
        double total = 0;

        for (Transacao transacao : transacoes) {
            total += transacao.getValor();
        }

        return total;
    }

    public double calcularTotalGorjetas() {
        return totalGorjetas;
    }

    public double calcularTotalRecebido() {
        return calcularTotalEntradas() + totalGorjetas;
    }

    public double calcularSaldo() {
        return calcularTotalRecebido() - totalSaidas;
    }

    public double getTotalSaidas() {
        return totalSaidas;
    }

    public int getQuantidadeTransacoes() {
        return transacoes.size();
    }

    public boolean possuiTransacaoDoPedido(int numeroPedido) {
        return transacoes.stream()
                .anyMatch(transacao -> transacao.getNumeroPedido() == numeroPedido);
    }
}
