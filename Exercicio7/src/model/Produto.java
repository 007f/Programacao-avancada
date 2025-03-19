package model;

public class Produto {
    private String nome;
    private int codigo;
    private Float preco;

    public Produto(String nome, int codigo, Float preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }


    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Preço: R$" + preco;
    }
}
