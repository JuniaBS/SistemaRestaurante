package app;

import cardapio.ItemCardapio;
import cardapio.Lanche;
import pedido.Pedido;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.InputMismatchException;

public class MenuConsole {

    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Modificar pedido");
        System.out.println("4 - Fechar restaurante");
        System.out.println("5 - Registrar despesa");
        System.out.println("6 - Consultar caixa");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        return lerNumero
                ("Escolha uma opção: ", 0, 6);
    }

    public String lerNomeCliente() {
        while (true) {
            System.out.print("Nome do cliente: ");
            String nome = scanner.nextLine();

            if (!nome.trim().isEmpty()) {
                return nome;
            }

            System.out.println("O nome do cliente não pode ser vazio.");
        }
    }

    public int lerOpcaoLanche() {
        System.out.println("\n=== CARDÁPIO ===");
        System.out.println("1 - X-Burger (R$ 16,00)");
        System.out.println("2 - X-Salada (R$ 18,00)");
        System.out.println("3 - X-Bacon (R$ 22,00)");

        return lerNumero("Escolha um lanche: ", 1, 3);
    }

    public void exibirMenuPersonalizacao() {

        System.out.println("\n=== PERSONALIZE SEU LANCHE ===");
    }

    public boolean lerDesejaQueijo() {

        return perguntar("Deseja queijo? (s/n): ");
    }

    public boolean lerDesejaAlface() {

        return perguntar("Deseja alface? (s/n): ");
    }

    public boolean lerDesejaTomate() {

        return perguntar("Deseja tomate? (s/n): ");
    }

    public boolean lerDesejaCebola() {

        return perguntar("Deseja cebola? (s/n): ");
    }

    public boolean lerDesejaCheddar() {
        return perguntar("Adicionar cheddar por R$ 4,00? (s/n): ");
    }

    public boolean lerDesejaBaconExtra() {

        return perguntar("Adicionar bacon extra por R$ 6,00? (s/n): ");
    }

    private boolean perguntar(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().equalsIgnoreCase("s");
    }

    public boolean desejaAdicionarLanche() {
        System.out.print("Deseja adicionar outro lanche? (s/n): ");
        return scanner.nextLine().equalsIgnoreCase("s");
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("\nPedido " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());

        for (ItemCardapio item : pedido.getItens()) {
            System.out.println(
                    item.getDescricao() + " - R$ " + item.getPreco()
            );
        }

        System.out.printf("Total: R$ %.2f%n", pedido.calcularTotal());
    }

    public void exibirPedidos(Collection<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        for (Pedido pedido : pedidos) {
            exibirPedido(pedido);
        }
    }

    public void exibirMensagem(String mensagem) {

        System.out.println(mensagem);
    }

    public int lerNumeroPedido() {
        return lerNumero(
                "Digite o número do pedido: ",
                1,
                Integer.MAX_VALUE
        );
    }

    public void exibirMenuModificarPedido() {
        System.out.println("\n=== MODIFICAR PEDIDO ===");
        System.out.println("1 - Acrescentar item");
        System.out.println("2 - Remover item");
        System.out.println("3 - Cancelar pedido");
        System.out.println("0 - Voltar");
    }

    public int lerOpcaoModificarPedido() {

        return lerNumero("Escolha uma opção: ", 0, 3);
    }

    public void exibirItensPedido(Pedido pedido) {
        System.out.println("\n=== ITENS DO PEDIDO ===");

        for (int i = 0; i < pedido.getItens().size(); i++) {
            ItemCardapio item = pedido.getItens().get(i);

            System.out.printf(
                    "%d - %s - R$ %.2f%n",
                    i + 1,
                    item.getDescricao(),
                    item.getPreco()
            );
        }
    }

    public int lerNumeroItem() {
        return lerNumero(
                "Digite o número do item que deseja remover: ",
                1,
                Integer.MAX_VALUE
        );
    }

    public double lerValorGorjeta() {

        return lerValor("Digite o valor das gorjetas recebidas: R$ ", true);
    }

    public void exibirFechamentoDoDia(
            double total,
            Set<String> combinacoes,
            Set<String> lanchesBase,
            double totalGorjetas,
            double totalEntradas,
            double totalSaidas,
            double saldo
    ) {
        System.out.println("\n===== FECHAMENTO DO DIA =====");
        System.out.printf("Total dos pedidos: R$ %.2f%n", total);
        System.out.printf("Total de gorjetas: R$ %.2f%n", totalGorjetas);
        System.out.printf("Total de entradas: R$ %.2f%n", totalEntradas);
        System.out.printf("Total de saídas: R$ %.2f%n", totalSaidas);
        System.out.printf("Saldo do caixa: R$ %.2f%n", saldo);

        System.out.println("\nLanches-base diferentes: " + lanchesBase.size());
        for (String lanche : lanchesBase) {
            System.out.println("- " + lanche);
        }

        System.out.println("\nCombinações diferentes: " + combinacoes.size());
        for (String combinacao : combinacoes) {
            System.out.println("- " + combinacao);
        }

        if (combinacoes.isEmpty()) {
            System.out.println("Nenhum item vendido hoje.");
        }

        System.out.println("============================");
    }

    public void exibirResumoCaixa(
            double totalEntradas,
            double totalSaidas,
            double saldo
    ) {
        System.out.println("\n===== RESUMO DO CAIXA =====");
        System.out.printf("Total de entradas: R$ %.2f%n", totalEntradas);
        System.out.printf("Total de saídas: R$ %.2f%n", totalSaidas);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.println("===========================");
    }

    private int lerNumero(String mensagem, int minimo, int maximo) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();

            try {
                int numero = Integer.parseInt(entrada);

                if (numero < minimo || numero > maximo) {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                }

                return numero;

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }

    private double lerValor(String mensagem, boolean permiteZero) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().replace(",", ".");

            try {
                double valor = Double.parseDouble(entrada);

                if (!Double.isFinite(valor)) {
                    System.out.println(
                            "O valor deve ser um número finito."
                    );
                    continue;
                }

                if (valor < 0 || (!permiteZero && valor == 0)) {
                    System.out.println(
                            permiteZero
                                    ? "O valor não pode ser negativo."
                                    : "O valor deve ser maior que zero."
                    );
                    continue;
                }

                return valor;

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um valor numérico.");
            }
        }
    }

    public double lerValorDespesa() {

        return lerValor("Digite o valor da despesa: R$ ", false);
    }
}
