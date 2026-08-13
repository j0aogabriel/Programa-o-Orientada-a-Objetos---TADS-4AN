import java.util.Scanner; //importando pacote util classe scanner

//System, Scanner, String sempre com S maiusculo 
public class Aula2_2{
    public static void main(String[] args) {

        // Criação do objeto Scanner
        Scanner entrada=new Scanner(System.in); //sistema operacional entrada

        // Declaração das variáveis
        String nome;
        int idade;
        double altura;

        // Entrada de dados
        System.out.print("Digite seu nome: ");
        nome=entrada.nextLine(); 

        System.out.print("Digite sua idade: ");
        idade=entrada.nextInt(); 

        System.out.print("Digite seu altura (em metros): ");
        altura=entrada.nextDouble();
        
        // Saída de dados
        System.out.println("\n=== DADOS INFORMADOS ===");
        System.out.println("Nome: "+nome);
        System.out.println("Idade: "+idade+" anos");
        System.out.println("Altura: "+altura+" m");        

        entrada.close(); 
    }
}

