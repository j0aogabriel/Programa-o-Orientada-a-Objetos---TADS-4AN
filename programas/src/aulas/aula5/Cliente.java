package aula5;

import javax.swing.JOptionPane;

public class Cliente extends Pessoa {
    private double limiteCredito;

    public Cliente(String nome, String telefone, double limiteCredito) throws LimiteInvalidoException {
        super(nome, telefone);
        setTitle("Cadastro de Cliente");

        setLimiteCredito(limiteCredito);

        configurarAcoesBotoes();
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) throws LimiteInvalidoException {
        if (limiteCredito < 0) {
            throw new LimiteInvalidoException("Limite de crédito não pode ser negativo.");
        }
        this.limiteCredito = limiteCredito;
    }

    public void alterarLimiteComTexto(String textoLimite) {
        try {
            double novoLimite = Double.parseDouble(textoLimite);
            setLimiteCredito(novoLimite);
            JOptionPane.showMessageDialog(this,
                "novo limite aplicado: R$" + novoLimite, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Erro: Digite apenas numeros validos!", "Falha na conversão", JOptionPane.ERROR_MESSAGE);
        } catch (LimiteInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Regra violada",
                JOptionPane.WARNING_MESSAGE);
        }
    }

    private void configurarAcoesBotoes() {
        btnIncluir.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Preparando formulário para novo cliente.",
                "Incluir Cliente",
                JOptionPane.INFORMATION_MESSAGE);
        });

        btnGravar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Dados salvos com sucesso! \nCliente: " + getNome() + "\nLimite: R$" + getLimiteCredito(),
                "ação: Gravar Cliente",
                JOptionPane.INFORMATION_MESSAGE);
        });

        btnExcluir.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(this,
                "Deseja realmente excluir o cliente " + getNome() + "?",
                "confirmação de exclusão",
                JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                System.out.println("Cliente " + getNome() + " excluído do banco simulado.");
            }
        });
    }
}