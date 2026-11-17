package view;

import controller.ProdutoController;
import java.awt.*;
import javax.swing.*;
import util.Mensagem;
import util.ResultadoCadastro;

public class TelaCadastroProduto extends JFrame {

    private final JTextField txtNome;
    private final JTextField txtMarca;
    private final JTextField txtPreco;
    private final JButton btnSalvar;

    // CORREÇÃO 1: Adicionado o nome da variável "controller"
    private final ProdutoController controller = new ProdutoController();

    public TelaCadastroProduto() {
        setTitle("Cadastrar Produto");
        setSize(300, 200);
        setLocationRelativeTo(null);
        // CORREÇÃO 3: Ajustado para GridLayout(4, 2) pois há 4 pares de elementos
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Novo Produto:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        add(txtMarca);

        add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        add(txtPreco);

        btnSalvar = new JButton("Salvar");
        add(new JLabel()); // Espaço vazio para alinhar o botão à direita
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                String marca = txtMarca.getText();
                // Converte o texto para Double
                Double preco = Double.parseDouble(txtPreco.getText());
                
                ResultadoCadastro resultado = controller.cadastrar(nome, marca, preco);

                switch (resultado) {
                    case SUCESSO -> {
                        Mensagem.info("Produto cadastrado com sucesso!");
                        dispose();
                    }
                    case JA_EXISTE -> Mensagem.erro("Já existe um produto com esse nome. Escolha outro.");
                    case ERRO_BANCO -> Mensagem.erro("Erro ao salvar no banco de dados.");
                }
            } catch (NumberFormatException ex) {
                // Previne que o programa "quebre" se o utilizador escrever letras no preço
                Mensagem.erro("Por favor, digite um valor numérico válido para o preço.");
            }
        });
    }
}