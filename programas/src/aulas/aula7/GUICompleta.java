import javax.swing.*;
import java.awt.Font;

public class GUICompleta { //janela oi objetos basicos
    public static void main(String[] args) {
        // 1. Criar a janela
        JFrame frame = new JFrame("Exemplo de GUI");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // layout absoluto

        // 2. Label
        JLabel lblNome = new JLabel("Digite seu nome:");
        lblNome.setBounds(20, 20, 150, 25);
        frame.add(lblNome);

        // 3. TextField
        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 20, 200, 25);
        frame.add(txtNome);

        // 4. Radio Buttons
        JRadioButton rbtnMasculino = new JRadioButton("Masculino");
        rbtnMasculino.setBounds(20, 60, 100, 25);
        JRadioButton rbtnFeminino = new JRadioButton("Feminino");
        rbtnFeminino.setBounds(130, 60, 100, 25);

        // Agrupar radio buttons
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbtnMasculino);
        grupoSexo.add(rbtnFeminino);

        frame.add(rbtnMasculino);
        frame.add(rbtnFeminino);

        // 5. CheckBox
        JCheckBox chkProgramador = new JCheckBox("Programador");
        chkProgramador.setBounds(20, 100, 120, 25);
        JCheckBox chkProfessor = new JCheckBox("Professor");
        chkProfessor.setBounds(200, 100, 120, 25);
        frame.add(chkProgramador);
        frame.add(chkProfessor);

        String[] cores = {"Vermelho", "Verde", "Azul"};
        JComboBox<String> cbxCores = new JComboBox<>(cores);
        cbxCores.setBounds(20, 140, 100, 25);
        frame.add(cbxCores);

        String[] frutas = {"Maçã", "Banana", "Laranja"};
        JList<String> lstFrutas = new JList<>(frutas);
        lstFrutas.setBounds(300, 140, 100, 60);
        frame.add(lstFrutas);

        JSlider slider = new JSlider(0, 100, 50);
        slider.setBounds(20, 170, 200, 50);
        frame.add(slider);

        // Ícone (opcional - só funciona se o caminho existir)
        ImageIcon icon = new ImageIcon("resources/imagens/scinternacional.png");
        JLabel lblIcone = new JLabel(icon);
        lblIcone.setBounds(20, 230, 200, 150);
        frame.add(lblIcone);

        // 6. Botão
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(150, 60, 100, 25);
        frame.add(btnEnviar);

        // 7. Area texto grande
        JTextArea jObservacao = new JTextArea();
        jObservacao.setEditable(true);
        jObservacao.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(jObservacao);
        scrollPane.setBounds(20, 390, 350, 90);
        frame.add(scrollPane);

        // 8. Ação do botão
        btnEnviar.addActionListener(e -> {
            String nome = txtNome.getText();
            String sexo = rbtnMasculino.isSelected() ? "Masculino" :
                          rbtnFeminino.isSelected() ? "Feminino" :
                          "Não selecionado";
            String programador = chkProgramador.isSelected() ? "Sim" : "Não";
            String professor = chkProfessor.isSelected() ? "Sim" : "Não";

            JOptionPane.showMessageDialog(frame,
                "Nome: " + nome + "\nSexo: " +
                sexo + "\nProgramador: " +
                programador + "\nProfessor: " + professor);
        });

        // 9. Centralizar (deve vir antes de exibir, após configurar tamanho)
        frame.setLocationRelativeTo(null);

        // 10. Mostrar a janela
        frame.setVisible(true);
    }
}