class Aluno2{
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
        Aluno a1=new Aluno2(); //objeto
        Aluno a2=new Aluno2(); //objeto

        a1.nome="Maria";
        a1.codigo=10;
        a2.nome="Maria";
        a2.codigo=10;

        System.out.println(a1);
        System.out.println(a1.equals(a2));
    }
}