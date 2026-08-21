import javax.swing.*;
import java.awt.*;
//flowlayout

public class Aula4_4 extends JFrame {

    private JLabel labelMensagem;

    JButton btn1;
    JButton btn2;
    JButton btn3;

    public Aula4_4(){

        setTitle("Cadastro de Aluno");
        setSize(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel=new JPanel();
        painel.setLayout(new BorderLayout());

        //Criando os componentes
        btn1=new JButton("Topo");
        btn2=new JButton("Centro");
        btn3=new JButton("Esquerda");
        
        labelMensagem=new JLabel("borderlayout",SwingConstants.CENTER);

        //Adicionando os componentes ao painel
        painel.add(btn1, BorderLayout.NORTH);
        painel.add(btn2, BorderLayout.CENTER);
        painel.add(btn3, BorderLayout.WEST);
        painel.add(labelMensagem, BorderLayout.SOUTH);

        //Evento do botão 1
        btn1.addActionListener(e->{
            labelMensagem.setText("Você clicou no Topo");
        });

        //Evento do botão 2
        btn2.addActionListener(e->{
            labelMensagem.setText("Você clicou no Centro");
        });

        //Evento do botão 3
        btn3.addActionListener(e->{
            labelMensagem.setText("Você clicou na Esquerda");
        });        

        // Adicionando o painel à janela
        add(painel);
        
    }

    public static void main(String[] args) {
        new Aula4_4().setVisible(true);
    }
    
}
