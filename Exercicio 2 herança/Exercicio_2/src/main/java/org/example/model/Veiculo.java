package org.example.model;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private int capacidadePassageiros;
    private String combustivel; //TIPO DE COMBUSTIVEL

    public Veiculo(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.capacidadePassageiros = capacidadePassageiros;
        this.combustivel = combustivel;
    }

    public abstract double calcularAutonomia();

    public void exibirDetalhes(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Capacidade: " + capacidadePassageiros);
        System.out.println("Combustivel: " + combustivel);
    };

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
}
