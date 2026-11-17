package view;

import dao.ProdutoDAO;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Produto;

public class CRUDProduto extends JFrame {
    private JTable tabelaProdutos;
    private DefaultTableModel model;
    private JButton btnNovo, btnEditar, btnExcluir;
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public CRUDProduto() {
        setTitle("Gerenciamento de Produtos");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabela baseada nas colunas da tabela produtos (id, nome, marca, preco)
        model = new DefaultTableModel(new String[]{"ID", "Nome", "Marca", "Preço"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // impede edição direta na célula
            }
        };
        tabelaProdutos = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        add(scrollPane, BorderLayout.CENTER);

        // Botões
        JPanel painelBotoes = new JPanel();
        btnNovo = new JButton("Novo");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        add(painelBotoes, BorderLayout.SOUTH);

        // Eventos usando lambda
        btnNovo.addActionListener(e -> abrirFormulario(null));
        btnEditar.addActionListener(e -> editarProduto());
        btnExcluir.addActionListener(e -> excluirProduto());

        carregarProdutos();
        setVisible(true);
    }

    private void carregarProdutos() {
        model.setRowCount(0);
        List<Produto> produtos = produtoDAO.listarTodos();
        for (Produto p : produtos) {
            model.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getMarca(),
                String.format("R$ %.2f", p.getPreco())
            });
        }
    }

    private void abrirFormulario(Produto produto) {
        FormularioProduto form = new FormularioProduto(this, produto);
        form.setVisible(true);
    }

    private void editarProduto() {
        int linha = tabelaProdutos.getSelectedRow();
        if (linha >= 0) {
            int id = (int) model.getValueAt(linha, 0);
            Produto produto = produtoDAO.buscarPorId(id);
            abrirFormulario(produto);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar!");
        }
    }

    private void excluirProduto() {
        int linha = tabelaProdutos.getSelectedRow();
        if (linha >= 0) {
            int id = (int) model.getValueAt(linha, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este produto?");
            if (confirm == JOptionPane.YES_OPTION) {
                boolean sucesso = produtoDAO.excluir(id);
                if (sucesso) {
                    carregarProdutos();
                    JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir produto!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
        }
    }

    public void atualizarTabela() {
        carregarProdutos();
    }
}