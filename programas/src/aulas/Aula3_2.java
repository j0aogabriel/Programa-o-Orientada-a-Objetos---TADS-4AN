import java.util.Scanner;

public class Aula3_2 {
//switch
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu:");
        System.out.println("1 - Novo");
        System.out.println("2 - Abrir");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Você escolheu Novo.");
                break;
            case 2:
                System.out.println("Você escolheu Abrir.");
                break;
            case 3:
                System.out.println("Você escolheu Sair.");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        
        sc.close();
        }

}   

