package app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuConsoleTest {

    private final java.io.InputStream entradaOriginal = System.in;

    @AfterEach
    void restaurarEntrada() {
        System.setIn(entradaOriginal);
    }

    @Test
    void deveRejeitarValoresNaoFinitosNaGorjeta() {
        configurarEntrada("NaN\nInfinity\n-Infinity\n10,50\n");

        MenuConsole menu = new MenuConsole();

        assertEquals(10.50, menu.lerValorGorjeta(), 0.001);
    }

    @Test
    void deveRejeitarValoresNaoFinitosNaDespesa() {
        configurarEntrada("NaN\nInfinity\n-Infinity\n25,00\n");

        MenuConsole menu = new MenuConsole();

        assertEquals(25.00, menu.lerValorDespesa(), 0.001);
    }

    @Test
    void deveAceitarGorjetaValida() {
        configurarEntrada("10,50\n");

        MenuConsole menu = new MenuConsole();

        assertEquals(10.50, menu.lerValorGorjeta(), 0.001);
    }

    @Test
    void deveSolicitarNovamenteNomeVazio() {
        configurarEntrada("\n   \nAna\n");

        MenuConsole menu = new MenuConsole();

        assertEquals("Ana", menu.lerNomeCliente());
    }

    @Test
    void deveAceitarNomeValido() {
        configurarEntrada("Ana\n");

        MenuConsole menu = new MenuConsole();

        assertEquals("Ana", menu.lerNomeCliente());
    }

    private void configurarEntrada(String entrada) {
        System.setIn(new ByteArrayInputStream(
                entrada.getBytes(StandardCharsets.UTF_8)
        ));
    }
}
