package pedido;

import cardapio.ItemCardapio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GerenciadorPedidosTest {

    @Test
    void deveCancelarPedidoExistente() {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos();
        Pedido pedido = gerenciador.criarPedido("Ana");

        boolean cancelado = gerenciador.cancelarPedido(pedido.getNumero());

        assertTrue(cancelado);
        assertNull(gerenciador.buscarPedido(pedido.getNumero()));
    }

    @Test
    void deveRetornarDescricoesSemDuplicatas() {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos();

        Pedido pedido1 = gerenciador.criarPedido("Ana");
        Pedido pedido2 = gerenciador.criarPedido("João");

        ItemCardapio item1 = mock(ItemCardapio.class);
        ItemCardapio item2 = mock(ItemCardapio.class);
        ItemCardapio item3 = mock(ItemCardapio.class);

        when(item1.getDescricao()).thenReturn("X-Burger");
        when(item2.getDescricao()).thenReturn("X-Burger");
        when(item3.getDescricao()).thenReturn("X-Salada");

        pedido1.adicionarItem(item1);
        pedido2.adicionarItem(item2);
        pedido2.adicionarItem(item3);

        var descricoes = gerenciador.obterCombinacoesDoDia();

        assertEquals(2, descricoes.size());
        assertTrue(descricoes.contains("X-Burger"));
        assertTrue(descricoes.contains("X-Salada"));
    }
}