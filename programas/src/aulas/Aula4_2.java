import javax.swing.*;

public class Aula4_2 extends JFrame {

    JTextField txtNome;
    JTextField txtEmail;
    JButton btnSalvar;

    public Aula4_2(){

        setTitle("Cadastro de Aluno");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel=new JPanel();

        painel.add(new JLabel("Nome:"));
        txtNome=new JTextField(20);
        painel.add(txtNome);

        painel.add(new JLabel("E-mail:"));
        txtEmail=new JTextField(20);
        painel.add(txtEmail);

        btnSalvar=new JButton("Salvar");
        painel.add(btnSalvar);

        add(painel);
    }

    public static void main(String[] args) {
        new Aula4_2().setVisible(true);
    }
    
}
