package org.example.model;

public class Carro extends Veiculo {
    private String TipoCarro;
    private int tanque = 50;
    private double consumo = 12.0;

    public Carro(String marca, String modelo, int ano, int capacidadePassageiros, String tipocarro) {
        super(marca, modelo, ano, capacidadePassageiros, "Alcool/gasolina");
        this.TipoCarro = tipocarro;
    }

    @Override
    public double calcularAutonomia() {
        return tanque * consumo;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo de Carro:" + TipoCarro);
    }
}
