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
        System.out.println(("5 - Comprar"));
        System.out.println("7 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public Product cadastrarProduto() {
        System.out.println("Cadastrar Produto");
        System.out.print("Digite o nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o Preço do Produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        return new Product(nome, preco);
    }

    public User cadastrarUsuario(){
        System.out.println("Cadastrar Usuário");
        System.out.print("Digite o nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email do Usuário: ");
        String email = scanner.nextLine();
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

    public void solicitarEmail(){
        System.out.print("Digite o email do Usuário: ");
    }

    public String solicitarProdutoIds() {
        System.out.print("Digite os IDs dos produtos (separados por vírgula): ");
        return scanner.nextLine();
    }

    public int selecionarFormaPagamento() {
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - Boleto");
        System.out.println("3 - PIX");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    public void exibirResumoVenda(User user, List<Product> produtos, double total, String formaPagamento) {
        System.out.println("\nResumo da Venda:");
        System.out.println("Cliente: " + user.getName());
        System.out.println("Produtos:");
        for (Product p : produtos) {
            System.out.printf("- %s (R$ %.2f)\n", p.getName(), p.getPrice());
        }
        System.out.printf("Valor total: R$ %.2f\n", total);
        System.out.println("Forma de pagamento: " + formaPagamento);
        System.out.println("Venda registrada com sucesso!");
    }
}
