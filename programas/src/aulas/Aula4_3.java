import javax.swing.*;
import java.awt.*;
//flowlayout

public class Aula4_3 extends JFrame {

    private JLabel labelMensagem;

    JButton btn1;
    JButton btn2;
    JButton btn3;

    public Aula4_3(){

        setTitle("Cadastro de Aluno");
        setSize(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel=new JPanel();
        painel.setLayout(new FlowLayout());

        //Criando os componentes
        btn1=new JButton("Botão 1");
        btn2=new JButton("Botão 2");
        btn3=new JButton("Botão 3");

        labelMensagem=new JLabel("Clique em um botão");
        labelMensagem.setText("flowlayout");

        //Adicionando os componentes ao painel
        painel.add(btn1);
        painel.add(btn2);
        painel.add(btn3);
        painel.add(labelMensagem);

        //Evento do botão 1
        btn1.addActionListener(e->{
            labelMensagem.setText("Botão 1");
        });

        //Evento do botão 2
        btn2.addActionListener(e->{
            labelMensagem.setText("Botão 2");
        });
        //Evento do botão 3
        btn3.addActionListener(e->{
            labelMensagem.setText("Botão 3");
        });
        

        // Adicionando o painel à janela
        add(painel);
        
    }

    public static void main(String[] args) {
        new Aula4_3().setVisible(true);
    }
    
}
