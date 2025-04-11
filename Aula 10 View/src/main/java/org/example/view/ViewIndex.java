package org.example.view;

import org.example.entities.Product;
import org.example.entities.User;

import java.util.List;
import java.util.Scanner;

public class ViewIndex {
    Scanner scanner = new Scanner(System.in);

    public void exibirMenu(){
        System.out.println("\n---MENU---");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listas Produtos");
        System.out.println("3 - Cadastrar Usuário");
        System.out.println("4 - Listar Usuários");
        System.out.println("5 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public Product cadastrarProduto() {
        System.out.println("Cadastrar Produto");
        System.out.print("Digite o nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o Preço do Produto: ");
        double preco = scanner.nextDouble();

        return new Product(nome, preco);
    }

    public User cadastrarUsuario(){
        System.out.println("Cadastrar Usuário");
        System.out.print("Digite o nome do Usuário: ");
        String nome = scanner.next();
        System.out.print("Digite o email do Usuário: ");
        String email = scanner.next();
        System.out.print("Digite a senha do Usuário: ");
        String senha = scanner.next();
        return new User(nome, email, senha);
    }

    public void exibirProdutos(List<Product> p){
        System.out.println("Listar Produtos");
        p.forEach(System.out::println);
    }

    public void exibirUsuarios(List<User> u){
        System.out.println("Listar Usuarios");
        u.forEach(System.out::println);
    }

}
