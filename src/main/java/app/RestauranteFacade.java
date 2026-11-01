package app;

import cardapio.ItemCardapio;
import cardapio.Lanche;
import cardapio.LancheFactory;
import cardapio.ComBaconExtra;
import cardapio.ComCheddar;
import pedido.GerenciadorPedidos;
import pedido.Pedido;
import financeiro.Caixa;
import financeiro.Transacao;

import java.util.Collection;
import java.util.Set;

public class RestauranteFacade {

    private final GerenciadorPedidos gerenciador =
            new GerenciadorPedidos();

    private final Caixa caixa = new Caixa();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public Lanche criarLanche(int opcao) {
        switch (opcao) {
            case 1:
                return LancheFactory.xBurger();
            case 2:
                return LancheFactory.xSalada();
            case 3:
                return LancheFactory.xBacon();
            default:
                throw new IllegalArgumentException(
                        "Opção de lanche inválida."
                );
        }
    }

    public ItemCardapio personalizarLanche(
            Lanche lanche,
            boolean queijo,
            boolean alface,
            boolean tomate,
            boolean cebola,
            boolean cheddar,
            boolean baconExtra
    ) {
        lanche.setQueijo(queijo);
        lanche.setAlface(alface);
        lanche.setTomate(tomate);
        lanche.setCebola(cebola);

        ItemCardapio item = lanche;

        if (cheddar) {
            item = new ComCheddar(item);
        }

        if (baconExtra) {
            item = new ComBaconExtra(item);
        }

        return item;
    }

    public void adicionarItem(
            Pedido pedido,
            ItemCardapio item
    ) {
        pedido.adicionarItem(item);
    }

    public Collection<Pedido> listarPedidos() {

        return gerenciador.getPedidos();
    }

    public double calcularTotalDoDia() {

        return gerenciador.calcularTotalDoDia();
    }

    public Pedido buscarPedido(int numero) {

        return gerenciador.buscarPedido(numero);
    }

    public boolean cancelarPedido(int numero) {
        if (caixa.possuiTransacaoDoPedido(numero)) {
            return false;
        }

        return gerenciador.cancelarPedido(numero);
    }

    public boolean registrarPedidosDoDia() {
        boolean houveNovoRegistro = false;

        for (Pedido pedido : gerenciador.getPedidos()) {
            if (pedido.getItens().isEmpty()) {
                continue;
            }

            if (registrarPedidoPago(pedido)) {
                houveNovoRegistro = true;
            }
        }

        return houveNovoRegistro;
    }

    public boolean removerItem(Pedido pedido, int indice) {

        return pedido.removerItem(indice);
    }

    public Set<String> obterCombinacoesDoDia() {

        return gerenciador.obterCombinacoesDoDia();
    }

    public Set<String> obterLanchesBaseDoDia() {

        return gerenciador.obterLanchesBaseDoDia();
    }

    // ===== CONTROLE FINANCEIRO =====

    public boolean registrarPedidoPago(Pedido pedido) {
        if (pedido == null || pedido.getItens().isEmpty()) {
            return false;
        }

        double valor = pedido.calcularTotal();

        if (valor <= 0) {
            return false;
        }

        Transacao transacao = new Transacao(
                pedido.getNumero(),
                valor
        );

        return caixa.registrarTransacao(transacao);
    }

    public void registrarSaidaCaixa(double valor) {

        caixa.registrarSaida(valor);
    }

    public void registrarGorjeta(double valor) {

        caixa.registrarGorjeta(valor);
    }

    public double consultarTotalGorjetas() {
        return caixa.calcularTotalGorjetas();
    }

    public double consultarTotalRecebido() {
        return caixa.calcularTotalRecebido();
    }

    public double consultarSaldoCaixa() {

        return caixa.calcularSaldo();
    }

    public double consultarTotalEntradas() {

        return caixa.calcularTotalEntradas();
    }

    public double consultarTotalSaidas() {

        return caixa.getTotalSaidas();
    }

    public int consultarQuantidadeTransacoes() {

        return caixa.getQuantidadeTransacoes();
    }
}
