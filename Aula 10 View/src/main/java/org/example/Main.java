package org.example;

import org.example.entities.Product;
import org.example.entities.User;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;
import org.example.view.ViewIndex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepository listaDeProdutos = null;
        UserRepository listaDeUsuarios = null;

        ViewIndex viewIndex = new ViewIndex();

        Connection conn = null;
        
        // Parâmetros de conexão
        String url = "jdbc:sqlite:database.sqlite";

        // Tentativa de conexão
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                listaDeProdutos = new ProductRepository(conn);
                listaDeUsuarios = new UserRepository(conn);
            } else {
                System.out.println("Falha na conexão.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

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
                    ;
            }

        } while (option != 5);

        scanner.close();
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
