package pedido;

import cardapio.Lanche;
import java.util.ArrayList;
import lombok.Getter;

@Getter
public class Pedido {

    private int numero;
    private String nomeCliente;

    private ArrayList<Lanche> itens = new ArrayList<>();

    public Pedido(int numero, String nomeCliente){
        this.numero = numero;
        setNomeCliente(nomeCliente);
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        this.nomeCliente = nomeCliente;
    }

    public void adicionarItem(Lanche lanche){
        itens.add(lanche);
    }

    public double calcularTotal(){
        double total = 0.0;

        for(Lanche item : itens){
            total += item.getPreco();
        }

        return total;
    }



}
