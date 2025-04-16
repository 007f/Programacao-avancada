package org.example.controller;

import org.example.entities.Product;
import org.example.entities.User;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;
import org.example.view.ViewIndex;

import java.util.List;
import java.util.Scanner;

public class ControllerIndex {
    ProductRepository listaDeProdutos = null;
    UserRepository listaDeUsuarios = null;

    public ControllerIndex(ProductRepository listaDeProdutos, UserRepository listaDeUsuarios) {
        this.listaDeProdutos = listaDeProdutos;
        this.listaDeUsuarios = listaDeUsuarios;
    }

    ViewIndex viewIndex = new ViewIndex();

    public void executar(){
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            viewIndex.exibirMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    Product produto = viewIndex.cadastrarProduto();
                    listaDeProdutos.save(produto);
                    break;
                case 2:
                    List<Product> products = listaDeProdutos.findAll();
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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
                    break;
            }

        } while (option != 5);
    }

}
