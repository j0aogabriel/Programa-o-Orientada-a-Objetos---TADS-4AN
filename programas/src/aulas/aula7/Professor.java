public class Professor extends Pessoa {

    private String disciplina;

    public Professor(String nome, String disciplina) {
        super(nome);
        this.disciplina = disciplina;
    }

    @Override
    public String apresentar() {
        return "Professor: " + getNome() +
               "\nDisciplina: " + disciplina;
    }
}