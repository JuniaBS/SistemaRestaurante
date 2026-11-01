package financeiro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaixaTest {

    @Test
    void deveCalcularCorretamenteOFechamentoFinanceiro() {
        Caixa caixa = new Caixa();

        caixa.registrarTransacao(new Transacao(1, 50.00));
        caixa.registrarTransacao(new Transacao(2, 30.00));
        caixa.registrarGorjeta(10.00);
        caixa.registrarSaida(20.00);

        assertEquals(80.00, caixa.calcularTotalEntradas(), 0.001);
        assertEquals(10.00, caixa.calcularTotalGorjetas(), 0.001);
        assertEquals(90.00, caixa.calcularTotalRecebido(), 0.001);
        assertEquals(70.00, caixa.calcularSaldo(), 0.001);
    }
}
