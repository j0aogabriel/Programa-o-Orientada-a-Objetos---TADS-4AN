public abstract class Pessoa {
    private String nome; // encapsulamento

    public Pessoa(String nome) { // constructor
        this.nome = nome;}

    public void setNome(String nome) { //setter
        this.nome = nome;}

    public String getNome() { //getter
        return nome;}

    public abstract String apresentar(); //metodo abstrato
}