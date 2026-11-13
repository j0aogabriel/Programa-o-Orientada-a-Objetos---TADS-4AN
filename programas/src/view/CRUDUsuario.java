package view;

import dao.UsuarioDAO;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

public class CRUDUsuario extends JFrame {
    private JTable tabelaUsuarios;
    private DefaultTableModel model;
    private JButton btnNovo, btnEditar, btnExcluir;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public CRUDUsuario() {
        setTitle("Gerenciamento de Usuários");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabela
        model = new DefaultTableModel(new String[] { "ID", "Nome",
         "Tipo", "Situação", "Data Criação" }, 0) {
            public boolean isCellEditable(int row, int column) {
                return false; // impede edição direta
            }
        };
        tabelaUsuarios = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabelaUsuarios);
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
        btnEditar.addActionListener(e -> editarUsuario());
        btnExcluir.addActionListener(e -> excluirUsuario());

        carregarUsuarios();
        setVisible(true);
    }

    private void carregarUsuarios() {
        model.setRowCount(0);
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        for (Usuario u : usuarios) {
            String tipoLegivel = u.getTipo().equals("A") ? 
            "Administrador" : "Usuário";
            String ativoLegivel = u.getAtivo().equals("T") ?
            "Ativo" : "Inativo";

            model.addRow(new Object[] {
                u.getid();
                u.getNome(),
                tipoLegivel
                ativoLegivel,
                u.getDataCriacao()
            });
        }
    }

    private void abrirFormulario(Usuario usuario) {
        // Abre a tela de cadastro existente passando o usuário (null se)
        FormularioUsuario form = new FormularioUsuario(this, usuario);
        form.setVisible(true);
    }

    private void editarUsuario() {
        int linha = tabelaUsuarios.getSelectedRow();
        if (linha >= 0) {
            int id = (int) model.getValueAt(linha, 0);
            Usuario usuario = usuarioDAO.buscarPorId(id);
            abrirFormulario(usuario);

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário "+
            "para editar!");
        }
    }

    private void excluirUsuario() {
        int linha = tabelaUsuarios.getSelectedRow();
        if (linha >= 0) {
            int id = (int) model.getValueAt(linha, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Deseja " +
                "realmente excluir este usuário?");
                if (confirm == JOptionPane.YES_OPTION) {
                    boolean sucesso = usuarioDAO.excluir(id);
                    if (sucesso) {
                        carregarUsuarios();
                        JOptionPane.showMessageDialog(this, "Usuario "+
                        "excluído com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao "+
                        "excluir usuário!");
                    }
                }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário "+
            "para excluir!");
        }
    }

    public void atualizarTabela() {
        carregarUsuarios();
    }
}