package controller;
// O pacote "controller" contém classes responsáveis
// por receber dados da View,
// aplicar regras de negócio e chamar o DAO.
// É o intermediário entre interfance e banco.

import dao.ProdutoDAO;     // DAO que fala diretamente com
// o banco de dados
import model.Produto;     // Classe de modelo que representa
// um produto
import util.ResultadoCadastro; // Enum que indica o
// resultado do processo (SUCESSO, ERRO, EXISTE etc.)

public class ProdutoController {

    // Cria um DAO para comunicação com o banco.
    // É "final" porque não será trocado durante a execução.
    private final ProdutoDAO pDAO = new ProdutoDAO();


    public ResultadoCadastro cadastrar(String nome, String marca,
        double preco) {

        // 1. Criar um objeto Produto (camada de model)
        Produto p = new Produto();

        // 2. Preencher seus dados.
        p.setNome(nome);
        p.setMarca(marca);
        p.setPreco(preco);

        // 3. Enviar o produto pronto para o DAO salvar no banco
        return pDAO.inserir(p);
    }

}