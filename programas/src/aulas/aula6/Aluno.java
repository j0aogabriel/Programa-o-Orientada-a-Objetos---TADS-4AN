public class Aluno extends Pessoa {

    private String curso;

    public Aluno(String nome, int idade, String curso) {
        super(nome, idade);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String apresentar() {
        return "Aluno: " + getNome()
                + " | Idade: " + getIdade()
                + " | Curso: " + curso;
    }
}