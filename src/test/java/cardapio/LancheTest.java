package cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LancheTest {

    @Test
    void deveRecusarPrecoNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Lanche("X-Burger", -1.00)
        );
    }

    @Test
    void deveRecusarPrecosNaoFinitos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Lanche("X-Burger", Double.NaN)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new Lanche("X-Burger", Double.POSITIVE_INFINITY)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new Lanche("X-Burger", Double.NEGATIVE_INFINITY)
        );
    }

    @Test
    void deveAceitarPrecoValido() {
        Lanche lanche = new Lanche("X-Burger", 16.00);

        assertEquals(16.00, lanche.getPreco(), 0.001);
    }

    @Test
    void xBaconComCheddarCusta26() {
        ItemCardapio lanche = new ComCheddar(LancheFactory.xBacon());

        assertEquals(26.0, lanche.getPreco(), 0.001);
    }

    @Test
    void devePersonalizarLancheSemAlterarPreco() {
        Lanche lanche = LancheFactory.xBacon();

        lanche.setCebola(false);
        lanche.setTomate(false);

        assertEquals("X-Bacon sem tomate sem cebola", lanche.getDescricao());
        assertEquals(22.00, lanche.getPreco(), 0.001);
    }
}
