package financeiro;

import java.util.Objects;

public class Transacao {

    private final int numeroPedido;
    private final double valor;

    public Transacao(int numeroPedido, double valor) {
        if (numeroPedido <= 0) {
            throw new IllegalArgumentException(
                    "O número do pedido deve ser positivo."
            );
        }

        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "O valor da transação deve ser positivo."
            );
        }

        this.numeroPedido = numeroPedido;
        this.valor = valor;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Transacao)) {
            return false;
        }

        Transacao outra = (Transacao) objeto;
        return numeroPedido == outra.numeroPedido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroPedido);
    }
}