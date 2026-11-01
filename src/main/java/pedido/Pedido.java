package pedido;

import cardapio.ItemCardapio;
import java.util.ArrayList;
import java.util.Set;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens = new ArrayList<>();

    public Pedido(int numero, String nomeCliente) {
        this.numero = numero;
        setNomeCliente(nomeCliente);
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O nome não pode ser vazio."
            );
        }

        this.nomeCliente = nomeCliente;
    }

    public void adicionarItem(ItemCardapio item) {
        if (item == null) {
            throw new IllegalArgumentException(
                    "O item não pode ser nulo."
            );
        }

        itens.add(item);

    }

    public double calcularTotal() {
        double total = 0.0;

        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }

        return total;

    }

    public boolean removerItem(int indice) {
        if (indice < 0 || indice >= itens.size()) {
            return false;

        }

        itens.remove(indice);
        return true;

    }

}
