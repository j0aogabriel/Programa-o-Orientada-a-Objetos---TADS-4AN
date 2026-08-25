package aula5;
//É uma regra de erro isolada. Amanhã, ela pode ser usada pela
//classe ContaBancaria ou Venda sem alterar o código do cliente.

public class LimiteInvalidoException extends RuntimeException { //heranca
    public LimiteInvalidoException(String mensagem) {
        super(mensagem); //classe pai
    }
}