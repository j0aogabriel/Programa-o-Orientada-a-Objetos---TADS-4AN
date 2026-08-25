//Modifica apenas a estrutura humana Padrão
//(pode ser herdada depois por Funcionario, Fornecedor, etc.)
//classe base com tela base
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pessoa extends JFrame { //heranca
    //Atributos de dados encapsulamento
    protected String nome;
    protected String telefone;

    // Atributos de Interface Gráfica básicos
    protected JButton btnIncluir;
    protected JButton btnGravar;
    protected JButton btnExcluir;
    protected JButton btnSair;
    protected JPanel painelBotoes;

    public Pessoa() { //constructor da classe pessoa
        // Inicializa a janela gráfica base
        setTitle("Cadastro de Pessoa"); //titulo da tela
        setSize(500, 300); //tamanho
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //funcao do botao sair
        setLocationRelativeTo(null); //centraliza a tela

        // Criando os componentes visuais
        btnIncluir = new JButton("Incluir");
        btnGravar = new JButton("Gravar");
        btnExcluir = new JButton("Excluir");
        btnSair = new JButton("Sair");
        painelBotoes = new JPanel(new FlowLayout());

        // Adicionando os botões ao painel comum
        painelBotoes.add(btnIncluir);
        painelBotoes.add(btnGravar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnSair);

        // Adiciona o painel a janela principal
        add(painelBotoes, "South");

        // Ação padrão do botão Sair (comum a todas as telas)
        btnSair.addActionListener(e -> System.exit(0));
        //btnSair -> seu botão de Sair.
        //addActionListener(...) -> define o que acontece quando o botão é acionado
        //e -> -> expressão lambda que representa o evento.
        //System.exit(0) -> encerra a aplicação Java.
        //0 -> indica que o programa terminou normalmente.
        //btnSair.addActionListener(new ActionListener() {
        //   @Override
        //   public void actionPerformance(ActionEvent e){
        //      System.exit(0);
        //   }
        //});
    }

    public Pessoa(String nome, String telefone) {
        this(); // Chama o construtor visual padrão acima
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters e Setters dos dados básicos
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}