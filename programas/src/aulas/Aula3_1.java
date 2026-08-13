import java.util.Scanner; // importando a biblioteca Scanner

public class Aula3_1 {
    //if e operadores aritméticos
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //= recepcao, == comparacao

        System.out.print("Digite um número: ");
        int num = sc.nextInt();
        //operador >  < >= <= != =

        if (num > 0) {
            System.out.println("O número é positivo.");
        } else if (num < 0) {
            System.out.println("O número é negativo.");
        } else {
            System.out.println("O número é igual zero.");
        }

        int resto = num % 2;
        if (resto == 0) {
            System.out.println("O número é par.");
        } 
        else {
            System.out.println("O número é ímpar.");
        }

        if (resto != 1) {
            System.out.println("O número é par.");
        } else {
            System.out.println("O número é ímpar.");
        }
        sc.close();
    }
}
