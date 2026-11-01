package app;

import cardapio.ItemCardapio;
import cardapio.Lanche;
import pedido.Pedido;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        RestauranteFacade sistema = new RestauranteFacade();

        boolean executando = true;

        while (executando) {
            menu.exibirMenu();
            int opcao = menu.lerOpcao();

            switch (opcao) {
                case 1: {
                    String nomeCliente = menu.lerNomeCliente();
                    Pedido pedido = sistema.criarPedido(nomeCliente);

                    boolean adicionarMais = true;

                    while (adicionarMais) {
                        int opcaoLanche = menu.lerOpcaoLanche();

                        Lanche lanche = sistema.criarLanche(opcaoLanche);
                        ItemCardapio item = menu.personalizarLanche(lanche);

                        sistema.adicionarItem(pedido, item);

                        adicionarMais = menu.desejaAdicionarLanche();
                    }

                    menu.exibirPedido(pedido);
                    break;
                }

                case 2:
                    menu.exibirPedidos(sistema.listarPedidos());
                    break;

                case 3: {
                    int numero = menu.lerNumeroPedido();
                    Pedido pedido = sistema.buscarPedido(numero);

                    if (pedido == null) {
                        menu.exibirMensagem("Pedido não encontrado.");
                        break;
                    }

                    boolean modificando = true;

                    while (modificando) {
                        menu.exibirPedido(pedido);
                        menu.exibirMenuModificarPedido();

                        int opcaoModificar =
                                menu.lerOpcaoModificarPedido();

                        switch (opcaoModificar) {
                            case 1: {
                                int opcaoLanche = menu.lerOpcaoLanche();
                                Lanche lanche =
                                        sistema.criarLanche(opcaoLanche);

                                ItemCardapio item =
                                        menu.personalizarLanche(lanche);

                                sistema.adicionarItem(pedido, item);

                                menu.exibirMensagem(
                                        "Item adicionado ao pedido."
                                );
                                break;
                            }

                            case 2: {
                                if (pedido.getItens().isEmpty()) {
                                    menu.exibirMensagem(
                                            "O pedido não possui itens."
                                    );
                                    break;
                                }

                                menu.exibirItensPedido(pedido);
                                int numeroItem = menu.lerNumeroItem();

                                boolean removido = sistema.removerItem(
                                        pedido,
                                        numeroItem - 1
                                );

                                if (removido) {
                                    menu.exibirMensagem(
                                            "Item removido com sucesso."
                                    );
                                } else {
                                    menu.exibirMensagem(
                                            "Número de item inválido."
                                    );
                                }
                                break;
                            }

                            case 3: {
                                sistema.cancelarPedido(numero);
                                menu.exibirMensagem("Pedido cancelado.");
                                modificando = false;
                                break;
                            }

                            case 0:
                                modificando = false;
                                break;

                            default:
                                menu.exibirMensagem("Opção inválida.");
                        }
                    }
                    break;
                }

                case 4: {
                    double total = sistema.calcularTotalDoDia();

                    Set<String> combinacoes =
                            sistema.obterCombinacoesDoDia();

                    Set<String> lanchesBase =
                            sistema.obterLanchesBaseDoDia();

                    boolean houveNovoRegistro = false;

                    for (Pedido pedido : sistema.listarPedidos()) {
                        if (pedido.getItens().isEmpty()) {
                            continue;
                        }

                        boolean registrado =
                                sistema.registrarPedidoPago(pedido);

                        if (registrado) {
                            houveNovoRegistro = true;
                        } else {
                            menu.exibirMensagem(
                                    "O pedido " + pedido.getNumero()
                                            + " já foi registrado no caixa."
                            );
                        }
                    }

                    // Solicita gorjetas somente quando há pedidos novos
                    // registrados neste fechamento.
                    if (houveNovoRegistro) {
                        double gorjeta = menu.lerValorGorjeta();
                        sistema.registrarGorjeta(gorjeta);
                    }

                    double totalGorjetas =
                            sistema.consultarTotalGorjetas();

                    double totalEntradas =
                            sistema.consultarTotalRecebido();

                    double totalSaidas =
                            sistema.consultarTotalSaidas();

                    double saldo =
                            sistema.consultarSaldoCaixa();

                    menu.exibirFechamentoDoDia(
                            total,
                            combinacoes,
                            lanchesBase,
                            totalGorjetas,
                            totalEntradas,
                            totalSaidas,
                            saldo
                    );
                    break;
                }

                case 5: {
                    double valor = menu.lerValorDespesa();
                    sistema.registrarSaidaCaixa(valor);

                    menu.exibirMensagem(
                            "Despesa registrada com sucesso."
                    );
                    break;
                }

                case 6: {
                    double entradas =
                            sistema.consultarTotalRecebido();

                    double saidas =
                            sistema.consultarTotalSaidas();

                    double saldo =
                            sistema.consultarSaldoCaixa();

                    menu.exibirResumoCaixa(
                            entradas,
                            saidas,
                            saldo
                    );
                    break;
                }

                case 0:
                    menu.exibirMensagem("Encerrando o sistema.");
                    executando = false;
                    break;

                default:
                    menu.exibirMensagem("Opção inválida.");
            }
        }
    }
}