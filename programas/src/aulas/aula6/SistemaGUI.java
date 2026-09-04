import java.awt.*;
import java.util.Map;
import javax.swing.*;

public class SistemaGUI extends JFrame {

    private final GerenciadorPessoas gerenciador;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtEspecifico;
    private JLabel lblEspecifico;
    private JComboBox<String> comboTipo;
    private JTextArea areaTexto;

    public SistemaGUI() {
        this.gerenciador = new GerenciadorPessoas();

        setTitle("Sistema POO - Cadastro Modular");
        setSize(750, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        criarInterface();
    }

    private void criarInterface() {

        // --- TOP (HEADER) ---
        JLabel titulo = new JLabel("Sistema de Cadastro - POO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(titulo, BorderLayout.NORTH);

        // --- FORMULÁRIO (WEST) ---
        JPanel painelFormulario = new JPanel(new GridLayout(5, 2, 8, 8));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Cadastro"));

        painelFormulario.add(new JLabel("ID:"));
        txtId = new JTextField();
        painelFormulario.add(txtId);

        painelFormulario.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelFormulario.add(txtNome);

        painelFormulario.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelFormulario.add(txtIdade);

        painelFormulario.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"Aluno", "Professor"});
        painelFormulario.add(comboTipo);

        lblEspecifico = new JLabel("Curso:");
        txtEspecifico = new JTextField();
        painelFormulario.add(lblEspecifico);
        painelFormulario.add(txtEspecifico);

        comboTipo.addActionListener(e -> atualizarRotuloEspecifico());

        add(painelFormulario, BorderLayout.WEST);

        // --- ÁREA DE TEXTO (CENTER) ---
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // --- BOTÕES (SOUTH) ---
        JPanel painelBotoes = new JPanel();
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar");
        JButton btnRemover = new JButton("Remover");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnRemover);
        add(painelBotoes, BorderLayout.SOUTH);

        // --- EVENTOS ---
        btnCadastrar.addActionListener(e -> cadastrar());
        btnListar.addActionListener(e -> listar());
        btnRemover.addActionListener(e -> remover());
    }

    private void atualizarRotuloEspecifico() {
        String tipo = (String) comboTipo.getSelectedItem();
        if ("Aluno".equals(tipo)) {
            lblEspecifico.setText("Curso:");
        } else {
            lblEspecifico.setText("Disciplina:");
        }
    }

    private void cadastrar() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nome = txtNome.getText().trim();
            int idade = Integer.parseInt(txtIdade.getText().trim());
            String campoEspecifico = txtEspecifico.getText().trim();

            if (nome.isEmpty() || campoEspecifico.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.");
                return;
            }

            String tipo = (String) comboTipo.getSelectedItem();
            Pessoa pessoa;

            if ("Aluno".equals(tipo)) {
                pessoa = new Aluno(nome, idade, campoEspecifico);
            } else {
                pessoa = new Professor(nome, idade, campoEspecifico);
            }

            boolean sucesso = gerenciador.cadastrar(id, pessoa);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro: Já existe um cadastro com esse ID.");
            }

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Insira valores numéricos válidos para ID e Idade.");
        }
    }

    private void listar() {
        areaTexto.setText("");

        if (gerenciador.estaVazio()) {
            areaTexto.setText("Nenhuma pessoa cadastrada.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Pessoa> entry : gerenciador.getPessoas().entrySet()) {
            sb.append("ID: ").append(entry.getKey()).append("\n")
              .append(entry.getValue().apresentar()).append("\n")
              .append("-----------------------------------\n");
        }
        areaTexto.setText(sb.toString());
    }

    private void remover() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());

            if (gerenciador.remover(id)) {
                JOptionPane.showMessageDialog(this, "Pessoa removida com sucesso!");
                listar();
            } else {
                JOptionPane.showMessageDialog(this, "ID não encontrado.");
            }

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Digite um ID válido no campo ID.");
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtIdade.setText("");
        txtEspecifico.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaGUI().setVisible(true));
    }
}