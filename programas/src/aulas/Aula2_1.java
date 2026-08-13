import java.util.Scanner; //importando pacote util classe scanner

//System, Scanner, String sempre com S maiusculo porque são classes
//entao padrao PascalCase
public class Aula2_1{
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);

        //out,print, nextLine sao metodos entao padrao camelCase
        System.out.print("Digite seu nome: ");
        String nome=entrada.nextLine(); //nextLine de texto digitado no teclado

        System.out.println("Olá, "+nome+"!");

        entrada.close(); //destruindo o objeto
    }
}
