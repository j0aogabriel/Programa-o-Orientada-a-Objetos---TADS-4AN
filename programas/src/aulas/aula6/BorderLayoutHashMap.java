
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class BorderLayoutHashMap extends JFrame {

    // HashMap: ID -> Nome do produto
    private HashMap<Integer, String> produtos;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextArea area;

    // Construtor atualizado
    public BorderLayoutHashMap() {

        // Criando o HashMap
        produtos = new HashMap<>();

        // Configurações da janela
        setTitle("Cadastro de Produtos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // BorderLayout
        setLayout(new BorderLayout());

        // PARTE DE CIMA
        JLabel titulo = new JLabel(
            "Cadastro de Produtos",
            SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(titulo, BorderLayout.NORTH);

        // PARTE DO CENTRO
        JPanel painel = new JPanel();

        painel.add(new JLabel("ID:"));
        txtId = new JTextField(5);
        painel.add(txtId);
        
        painel.add(new JLabel("Produto:"));
        txtNome = new JTextField(15);
        painel.add(txtNome);
        
        add(painel, BorderLayout.CENTER);

        // PARTE DE BAIXO
        JPanel botoes = new JPanel();

        JButton cadastrar = new JButton("Cadastrar");
        JButton listar = new JButton("Listar");
        JButton remover = new JButton("Remover");

        botoes.add(cadastrar);
        botoes.add(listar);
        botoes.add(remover);

        add(botoes, BorderLayout.SOUTH);

        // ÁREA DE TEXTO (EAST)
        area = new JTextArea(10, 20);
        add(new JScrollPane(area), BorderLayout.EAST);

        // EVENTOS
        cadastrar.addActionListener(e -> cadastrarProduto());
        listar.addActionListener(e -> listarProdutos());
        remover.addActionListener(e -> removerProduto());
    }

    // Cadastrar produto
    private void cadastrarProduto() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nome = txtNome.getText().trim();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, informe o nome do produto.");
                return;
            }

            produtos.put(id, nome);

            JOptionPane.showMessageDialog(this, "Produto cadastrado!");

            txtId.setText("");
            txtNome.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um ID numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Listar produtos
    private void listarProdutos() {
        area.setText("");

        if (produtos.isEmpty()) {
            area.append("Nenhum produto cadastrado.\n");
            return;
        }

        for (Integer id : produtos.keySet()) {
            String nome = produtos.get(id);
            area.append("ID: " + id + " - Produto: " + nome + "\n");
        }            
    }

    // Remover produto
    private void removerProduto() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            
            if (produtos.containsKey(id)) {
                produtos.remove(id);
                JOptionPane.showMessageDialog(this, "Produto removido!");
                listarProdutos();
                txtId.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "ID não encontrado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um ID numérico para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BorderLayoutHashMap tela = new BorderLayoutHashMap();
            tela.setVisible(true);
        });
    }
}