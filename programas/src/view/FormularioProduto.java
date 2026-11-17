package view;

import dao.ProdutoDAO;
import java.awt.*;
import javax.swing.*;
import model.Produto;

public class FormularioProduto extends JDialog {
    private JTextField txtNome;
    private JTextField txtMarca;
    private JTextField txtPreco;
    private JButton btnSalvar;
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private Produto produto;
    private CRUDProduto parent;

    public FormularioProduto(CRUDProduto parent, Produto produto) {
        super(parent, true);
        this.parent = parent;
        this.produto = produto;

        setTitle(produto == null ? "Novo Produto" : "Editar Produto");
        setSize(350, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(parent);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        add(txtMarca);

        add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        add(txtPreco);

        btnSalvar = new JButton("Salvar");
        add(new JLabel());
        add(btnSalvar);

        // Preenche os campos se for edição
        if (produto != null) {
            txtNome.setText(produto.getNome());
            txtMarca.setText(produto.getMarca());
            txtPreco.setText(String.valueOf(produto.getPreco()));
        }

        btnSalvar.addActionListener(e -> salvarProduto());
    }

    private void salvarProduto() {
        try {
            String nome = txtNome.getText().trim();
            String marca = txtMarca.getText().trim();
            String precoTexto = txtPreco.getText().trim().replace(",", ".");

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome obrigatório!");
                return;
            }

            if (precoTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preço obrigatório!");
                return;
            }

            double preco = Double.parseDouble(precoTexto);

            if (produto == null) { // Novo produto
                Produto p = new Produto();
                p.setNome(nome);
                p.setMarca(marca);
                p.setPreco(preco);

                produtoDAO.inserir(p);
            } else { // Editar produto existente
                produto.setNome(nome);
                produto.setMarca(marca);
                produto.setPreco(preco);

                produtoDAO.gravar(produto);
            }

            parent.atualizarTabela();
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um valor numérico válido para o preço!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar produto!");
        }
    }
}