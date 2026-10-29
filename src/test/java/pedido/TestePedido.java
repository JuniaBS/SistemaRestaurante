package pedido;

import cardapio.Lanche;

public class TestePedido {
    public static void main(String[] args) {

        Pedido pedido = new Pedido(1, "Maria");

        Lanche hamburguer = new Lanche("Hambúrguer", 20.0);
        Lanche suco = new Lanche("Suco", 15.0);

        pedido.adicionarItem(hamburguer);
        pedido.adicionarItem(suco);

        System.out.println("Número do pedido: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());
        System.out.println("Quantidade de itens: " + pedido.getItens().size());

    }
}
