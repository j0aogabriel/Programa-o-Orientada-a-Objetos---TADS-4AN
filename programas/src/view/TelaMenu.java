package view;

import java.awt.*;
import javax.swing.*;
import model.Usuario;

public class TelaMenu extends JFrame {

    private final Usuario usuario;

    public TelaMenu(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Menu Principal - Usuário: " + usuario.getLogin());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Barra de Menu
        JMenuBar menuBar = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuUsuario = new JMenuItem("Usuário");
        JMenuItem menuClientes = new JMenuItem("Clientes");
        JMenuItem menuProdutos = new JMenuItem("Produtos");

        menuCadastro.add(menuUsuario);
        menuCadastro.add(menuClientes);
        menuCadastro.add(menuProdutos);

        JMenu menuSair = new JMenu("Sair");
        JMenuItem sair = new JMenuItem("Logout");
        menuSair.add(sair);

        menuBar.add(menuCadastro);
        menuBar.add(menuSair);
        setJMenuBar(menuBar);

        // Saudação central
        JLabel lblSaudacao = new JLabel("Bem-vindo, " + usuario.getLogin() + "!");
        lblSaudacao.setFont(new Font("Arial", Font.BOLD, 16));
        lblSaudacao.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblSaudacao, BorderLayout.CENTER); // Corrigido: componente adicionado ao JFrame

        // === Ações ===
        menuUsuario.addActionListener(e -> new CRUDUsuario());
        menuClientes.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, "Módulo de Clientes em desenvolvimento!")
        );
        menuProdutos.addActionListener(e -> new CRUDProduto());

        sair.addActionListener(e -> {
            dispose();
            new TelaLogin().setVisible(true);
        });
    }
}