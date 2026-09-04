
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GridLayoutArrayList extends JFrame {
    
    // ArrayList para armazenar as tarefas
    private ArrayList<String> listaTarefas;

    // Componentes da interface
    private JTextField campoTarefa;
    private JTextArea areaTexto; 
    private JButton botaoAdd; 
    private JButton botaoLimpar;

    public GridLayoutArrayList() {
        // Inicializa o ArrayList
        listaTarefas = new ArrayList<>();

        // Configurações básicas da janela (JFrame)
        setTitle("Gerenciador de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Define o Layout Principal como GridLayout (4 Linhas, 1 Coluna)
        setLayout(new GridLayout(4, 1, 10, 10)); 

        // -- Linha 1: Painel de Entrada de Dados
        JPanel painelEntrada = new JPanel(new GridLayout(1, 2, 5, 5));
        JLabel labelTarefa = new JLabel("Nova Tarefa:", SwingConstants.CENTER);
        campoTarefa = new JTextField();

        painelEntrada.add(labelTarefa);
        painelEntrada.add(campoTarefa);

        // -- Linha 2: Painel de Botões ---
        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 5, 5));

        botaoAdd = new JButton("Adicionar");
        botaoLimpar = new JButton("Limpar TUDO");

        painelBotoes.add(botaoAdd);
        painelBotoes.add(botaoLimpar);

        // -- Linha 3 e 4: Área de exibição
        areaTexto = new JTextArea();

        // O usuário não poderá digitar diretamente na área
        areaTexto.setEditable(false); 

        // Cria uma barra de rolagem
        JScrollPane scroll = new JScrollPane(areaTexto);

        // Adiciona os painéis à janela 
        add(painelEntrada);
        add(painelBotoes);
        add(scroll);

        // EVENTO DO BOTÃO ADICIONAR 
        botaoAdd.addActionListener(e -> { 
            
            // Pega o texto digitado
            String tarefa = campoTarefa.getText().trim();

            // Verifica se o campo não está vazio
            if (!tarefa.isEmpty()) {

                // Adiciona a tarefa na lista
                listaTarefas.add(tarefa);

                // Mostra as tarefas na tela
                mostrarTarefas();

                // Limpa o campo
                campoTarefa.setText("");

                // Coloca o cursor novamente no campo
                campoTarefa.requestFocus();
            
            } else {
                JOptionPane.showMessageDialog(this, "Digite uma tarefa!");
            }
        });

        // EVENTO DO BOTÃO LIMPAR
        botaoLimpar.addActionListener(e -> {
            // Remove todas as tarefas da lista
            listaTarefas.clear();

            // Atualiza a tela
            mostrarTarefas();
        });
    }

    // MÉTODO PARA MOSTRAR AS TAREFAS
    private void mostrarTarefas() {
        // Limpa a área de texto
        areaTexto.setText("");

        // Contador para numerar as tarefas
        int numero = 1;
        
        // Percorre a lista 
        for(String tarefa : listaTarefas) {
            areaTexto.append(numero + " - " + tarefa + "\n");
            numero++;
        }
    }

    // MÉTODO MAIN
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            GridLayoutArrayList janela = new GridLayoutArrayList(); 
            janela.setVisible(true);
        });
    }
}