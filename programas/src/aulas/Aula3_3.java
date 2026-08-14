//resolvendo problema com , e . usando Locale
import java.util.Locale;
import java.util.Scanner;

public class Aula3_3 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.of("pt", "BR"));

        System.out.print("Digite um número: ");
        double valor = entrada.nextDouble();

        System.out.println("Valor digitado: " + valor);

        entrada.close();
    }
    
}
