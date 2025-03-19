import model.Produto;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Produto> produtos = new HashMap<>();
        int opcao, cod;
        String nm;
        Float TMP;


        do {
            System.out.println("\n--- Menu --");
            System.out.println("\n1- Cadastrar Produto");
            System.out.println("\n2- Buscar produto por Código");
            System.out.println("\n3- Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Opção de cadastro selecionada.");
                    System.out.println("Digite o nome do produto");
                    nm = scanner.next();
                    System.out.println("Digite o codigo do produto");
                    cod = scanner.nextInt();
                    if (produtos.containsKey(cod)) {
                        System.out.println("Erro: Código já cadastrado!");
                        break;
                    }
                    System.out.println("Digite o preço do produto");
                    TMP = scanner.nextFloat();

                    Produto produto = new Produto(nm, cod, TMP);
                    produtos.put(cod, produto);

                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Opção de busca selecionada.");
                    System.out.print("Digite o código do produto para buscar: ");
                    cod = scanner.nextInt();

                    Produto encontrado = produtos.get(cod);
                    if(encontrado!=null){
                        System.out.println("Produto encontrado: " +
                                "\nCódigo: " + encontrado.getCodigo() +
                                "\nNome: " + encontrado.getNome() +
                                "\nPreço: R$" + encontrado.getPreco());
                    } else {
                        System.out.println("Produto não encontrado.");
                    }

                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}