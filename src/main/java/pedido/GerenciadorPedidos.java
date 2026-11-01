package pedido;

import cardapio.ItemCardapio;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GerenciadorPedidos {

    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public Pedido criarPedido(String nomeCliente) {
        Pedido novo = new Pedido(contadorPedidos, nomeCliente);

        pedidos.put(novo.getNumero(), novo);

        contadorPedidos++;

        return novo;
    }

    public Pedido buscarPedido(int numero) {
        return pedidos.get(numero);
    }

    public Collection<Pedido> getPedidos(){

        return pedidos.values();
    }

    public double calcularTotalDoDia(){
        double total = 0;

        for (Pedido p : pedidos.values()){
            total += p.calcularTotal();
        }

        return total;
    }

    public boolean cancelarPedido(int numero) {

        return pedidos.remove(numero) != null;

    }

    public Set<String> obterCombinacoesDoDia() {
        Set<String> combinacoes = new HashSet<>();

        for (Pedido pedido : pedidos.values()) {
            for (ItemCardapio item : pedido.getItens()) {
                combinacoes.add(item.getDescricao());
            }
        }

        return combinacoes;

    }

    public Set<String> obterLanchesBaseDoDia() {
        Set<String> lanchesBase = new HashSet<>();

        for (Pedido pedido : pedidos.values()) {
            for (ItemCardapio item : pedido.getItens()) {
                lanchesBase.add(item.getNomeBase());
            }
        }

        return lanchesBase;
    }

}
