package revisao;
import javax.swing.JOptionPane;

public class revisao {
    public static void main(String[] args) {

        //1. INFORMATION_MESSAGE
        JOptionPane.showMessageDialog(
            null,
            "Esta é uma mensagem de informação",
            "Informação",
            JOptionPane.INFORMATION_MESSAGE
        );

        //2. WARNING_MESSAGE
        JOptionPane.showMessageDialog(null,
            "Cuidado! Esta é uma menasgem de aviso.",
            "Aviso",
            JOptionPane.WARNING_MESSAGE
        );

        //3. ERROR_MESSAGE
        JOptionPane.showMessageDialog(
            null,
            "Ocorreu um erro!",
            "Erro",
            JOptionPane.ERROR_MESSAGE
        );

        //4. QUESTION_MESSAGE
        JOptionPane.showMessageDialog(
            null,
            "Esta é uma pergunta",
            "Pergunta",
            JOptionPane.QUESTION_MESSAGE
        );

        //5. PLAIN_MESSAGE
        JOptionPane.showMessageDialog(
            
            null,
            "Esta mensagem não possui ícone",
            "Mensagem simples",
            JOptionPane.PLAIN_MESSAGE
        );

        //6. showConfirmDialog - Sim/Não
        int resposta = JOptionPane.showConfirmDialog(
            null, 
            "Você gosta de Java?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você respondeu SIM!");
        } else {
            JOptionPane.showMessageDialog(null, "Você respondeu NÃO!");
        }

        //7. showInputDialog - entrada de texto
        String nome = JOptionPane.showInputDialog(
            null,
            "Digite seu nome:"
        );

        JOptionPane.showMessageDialog(
            null, 
            "Olá" + nome + "!"
        );

        //8. showOptionDialog - opções personalizadaaas
        String[] opcoes = {"Java", "Python", "C++"};

        int escolha = JOptionPane.showOptionDialog(
            null,
            "Qual linguagem você prefere?",
            "Escolha uma opção",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcoes,
            opcoes[0]
        );

        if (escolha >= 0) {
            JOptionPane.showMessageDialog(
                null, 
                "Você escolheu: " + opcoes[escolha]
            );
        }

        //Final
        JOptionPane.showMessageDialog(
            null,
            "Demonstração finalizada!",
            "fim",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}