package model;

public class Produto{
    private int id;
    private String nome;
    private double preco;
    private String marca;

    public int getId(){ //Retorna o ID do produto
        return id;
    }

    public void setId(int id){ //Define o ID do produto
        this.id=id;
    }

    public String getNome() { //Retorna o nome do produto
        return nome;
    }

    public void setNome(String nome) { //Define o nome do produto
        this.nome = nome;
    }

    public double getPreco() { //Retorna o preço do produto
        return preco;
    }

    public void setPreco(double preco) { //Define o preço do produto
        this.preco = preco;
    }

    public String getMarca() { //Retorna a marca do produto
        return marca;
    }

    public void setMarca(String marca) { //Define a marca do produto
        this.marca = marca;
    }
}