package org.example.controller;

import org.example.entities.*;
import org.example.paymentMethods.PaymentManager;
import org.example.paymentMethods.PaymentMethod;
import org.example.paymentMethods.PaymentMethodFactory;
import org.example.paymentMethods.PaymentType;
import org.example.repository.*;
import org.example.view.ViewIndex;

import java.util.*;

public class ControllerIndex {
    ProductRepository listaDeProdutos = null;
    UserRepository listaDeUsuarios = null;
    SaleRepository listaDeVendas = null;

    public ControllerIndex(ProductRepository listaDeProdutos, UserRepository listaDeUsuarios, SaleRepository listaDeVendas) {
        this.listaDeProdutos = listaDeProdutos;
        this.listaDeUsuarios = listaDeUsuarios;
        this.listaDeVendas = listaDeVendas;
    }

    ViewIndex viewIndex = new ViewIndex();

    public void executar(){
        Scanner scanner = new Scanner(System.in);
        int option;
        String email;
        List<Product> products;


        do {
            email = "";
            viewIndex.exibirMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Product produto = viewIndex.cadastrarProduto();
                    listaDeProdutos.save(produto);
                    break;
                case 2:
                    products = listaDeProdutos.findAll();
                    viewIndex.exibirProdutos(products);
                    break;
                case 3:
                    User usuario = viewIndex.cadastrarUsuario();
                    listaDeUsuarios.save(usuario);
                    break;
                case 4:
                    List<User> users = listaDeUsuarios.findAll();
                    viewIndex.exibirUsuarios(users);
                    break;
                case 5:
                    viewIndex.solicitarEmail();
                    email = scanner.nextLine();
                    Optional<User> userTMP = listaDeUsuarios.findByEmail(email);
                    if (userTMP.isEmpty()) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }
                    User user = userTMP.get();
                    System.out.println("Usuário encontrado: " + user.getName());
                    products = listaDeProdutos.findAll();
                    viewIndex.exibirProdutos(products);

                    String ids = viewIndex.solicitarProdutoIds();
                    String[] idArray = ids.split(",");

                    List<Product> produtosSelecionados = new ArrayList<>();
                    for (String idStr : idArray) {
                        try {
                            UUID id = UUID.fromString(idStr.trim());
                            Optional<Product> p = listaDeProdutos.findById(id);
                            p.ifPresent(produtosSelecionados::add);
                        } catch (IllegalArgumentException e) {
                            System.out.println("ID inválido: " + idStr);
                        }
                    }

                    if (produtosSelecionados.isEmpty()) {
                        System.out.println("Nenhum produto válido selecionado.");
                        break;
                    }

                    int opcaoPagamento = viewIndex.selecionarFormaPagamento();

                    PaymentType paymentType = switch (opcaoPagamento) {
                        case 1 -> PaymentType.CARTAO;
                        case 2 -> PaymentType.BOLETO;
                        case 3 -> PaymentType.PIX;
                        default -> throw new RuntimeException("Opção invalida.");
                    };

                    PaymentMethod payment = PaymentMethodFactory.create(paymentType);
                    PaymentManager manager = new PaymentManager();
                    manager.setPaymentMethod(payment);

                    double total = produtosSelecionados.stream()
                            .mapToDouble(Product::getPrice)
                            .sum();

                    System.out.println("Aguarde, efetuando pagamento...");
                    manager.pay(total);

                    // Criar a venda e salvar
                    Sale sale = new Sale(user.getUuid(), produtosSelecionados, payment);
                    listaDeVendas.save(sale);

                    viewIndex.exibirResumoVenda(user, produtosSelecionados, total, paymentType.name());

                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
                    break;
            }

        } while (option != 7);
    }

}
