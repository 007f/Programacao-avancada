package org.example.model;

public class CarroEletrico extends Carro{
    private double bateriaKwh;
    private double consumo = 5.0;

    public CarroEletrico(String marca, String modelo, int ano, int capacidadePassageiros, String tipoCarro, double bateriaKwh) {
        super(marca, modelo, ano, capacidadePassageiros, tipoCarro);
        this.bateriaKwh = bateriaKwh;
        this.setCombustivel("Elétrico");
    }

    @Override
    public double calcularAutonomia() {
        return bateriaKwh * consumo;
    }

}
