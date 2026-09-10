import javax.swing.*;

public class TelaPessoa extends JFrame {//heranca

    private JTextField txtNome; //encapsulamento
    private JComboBox<String> cbTipo; //encapsulamento
    private JTextField txtInfo; //encapsulamento
    private JButton btnMostrar; //encapsulamento

    public TelaPessoa() { //constructor

        setTitle("Cadastro"); //toda a parte de criacao da tela
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 30, 80, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 30, 220, 25);
        add(txtNome);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 70, 80, 25);
        add(lblTipo);

        cbTipo = new JComboBox<>(
            new String[]{"Aluno", "Professor"}
        );
        cbTipo.setBounds(100, 70, 220, 25);
        add(cbTipo);

        JLabel lblInfo = new JLabel("Informação:");
        lblInfo.setBounds(30, 110, 80, 25);
        //posição horizontal x, posição vertical y, largura width, altura height
        add(lblInfo);

        txtInfo = new JTextField();
        txtInfo.setEditable(false);
        txtInfo.setBounds(100, 110, 220, 25);

        add(txtInfo);

        btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(130, 160, 120, 30);
        add(btnMostrar);

        btnMostrar.addActionListener(e -> mostrar());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrar() {

        String nome = txtNome.getText();
        String tipo = cbTipo.getSelectedItem().toString();

        Pessoa pessoa; //usando classe abstrata

        if (tipo.equals("Aluno")) {
            pessoa = new Aluno(nome, 8.5);
            //usando classe filha aluno
        } else {
            pessoa = new Professor(nome, "Java");
            //usando classe filha professor
        }

        txtInfo.setText(
            pessoa.apresentar().replace("\n", " - ")
        );
    }

    public static void main(String[] args) {
        new TelaPessoa();
    }
}