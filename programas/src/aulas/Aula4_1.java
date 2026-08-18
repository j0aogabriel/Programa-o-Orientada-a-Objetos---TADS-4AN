
import javax.swing.*; // Importa os componentes gráficos básicos
//(JFrame, JButton, JLabel etc.)
import java.awt.*; // Importa classes para controle de layout
// (como FlowLayout)
import java.awt.event.*; // Importa classes para tratamento
// de eventos (como ActionListener)

/* Classe Aula4_1 
 * Exibe uma janela gráfica onde o usuário pode digitar seu nome e receber uma saudação
 * Utiliza a biblioteca Swing para criar a interface.
 */
public class Aula4_1 extends JFrame {

    // Componentes da interface
    private JTextField campoNome; // Campo de texto para digitar o nome
    private JButton botaoSaudar; // Botão que aciona a saudação
    private JLabel labelMensagem; // Label onde a mensagem será exibida

    /*
     * Construtor da classe Aula4_1
     * Configura a janela e os componentes gráficos.
     */
    public Aula4_1() {
        // Define o título da janela
        setTitle("Programação de Saudação");

        // Define o tamanho da janela (largura x altura)
        setSize(350, 150);

        // Define a operação padrão ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Cria o painel principal com layout de fluxo (elementos lado a lado)
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        // Cria o campo de texto onde o usuário digita o nome
        campoNome = new JTextField(20);

        // Cria o botão que executa a saudação
        botaoSaudar = new JButton("Saudar");

        // Cria o label com a mensagem inicial
        labelMensagem = new JLabel("Digite seu nome e clique em Saudar");

        // Adiciona os componentes ao painel
        painel.add(new JLabel("Nome:")); // Rótulo fixo "Nome:"
        painel.add(campoNome); // Campo de entrada
        painel.add(botaoSaudar); // Botão
        painel.add(labelMensagem); // Mensagem de resposta

        // Define o que acontece quando o botão for clicado
        botaoSaudar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega o nome digitado e remove espaços em branco
                String nome = campoNome.getText().trim();

                // Verifica se o campo está vazio
                if (nome.isEmpty()) {
                    labelMensagem.setText("Por favor, digite seu nome!");
                } else {
                    labelMensagem.setText("Olá, " + nome + "! Seja bem-vindo(a)!");
                }
            }
        });

        // Adiciona o painel configurado a janela principal
        add(painel);
    }

    /** 
     * Método principal - ponto de entrada do programa.
     * Inicia a interface gráfica usando a thread da Swing.
     */

    public static void main(String[] args) {
        // Garante que a interface gráfica será de forma segura
        // na thread do Swing
        SwingUtilities.invokeLater(() -> {
            // Cria uma instância da janela e a torna visível
            Aula4_1 janela = new Aula4_1();
            janela.setVisible(true); // Torna a janela visível
        });
    }
}