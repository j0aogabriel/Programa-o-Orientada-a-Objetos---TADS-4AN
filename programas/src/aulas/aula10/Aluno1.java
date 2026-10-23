class Aluno1{
    String nome;
    int codigo;

    @Override //polimorfismo
    public String toString(){
        return "Código: "+codigo
                +" | Nome: "+nome;
    }
}

public class Main{
    public static void main(String[] args) {
        Aluno a1=new Aluno1(); //objeto

        a1.nome="Maria";
        a1.codigo=10;

        System.out.println(a1);
    }
}