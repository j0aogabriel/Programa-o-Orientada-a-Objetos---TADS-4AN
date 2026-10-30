package dao;

import java.sql.*; // Importações para acesso ao banco
import java.util.ArrayList; // Estruturas auxiliares
import java.util.List; // Estruturas auxiliares
import model.Produto; // Importação das classes de modelo e utilidades
import util.ResultadoCadastro; // Importação das classes de modelo e utilidades

// Classe responsável pelo acesso ao banco de dados dos usuários
public class ProdutoDAO {

    // MÉTODO: inserir produto
    public ResultadoCadastro inserir(Produto produto) {

        // Primeiro verifica se o usuário já existe
        if (existeProduto(produto.getNome())) {
            return ResultadoCadastro.JA_EXISTE;
        }

        // SQL para inserir novo usuário
        String sql = "INSERT INTO produtos " +
                     "(nome, preco, marca) " +
                     "VALUES (?, ?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getMarca());

            stmt.executeUpdate();

            return ResultadoCadastro.SUCESSO;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " +
                e.getMessage());
            return ResultadoCadastro.ERRO_BANCO;
        }

    }
    public boolean existeProduto(String nomeProduto) {
        String sql = "SELECT 1 FROM produtos WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nomeProduto);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next(); // Retorna true se encontrou

    } catch (SQLException e) {
        System.out.println("Erro ao verificar produto: " + e.getMessage());
        return false; // falha por erro no banco
    }

}
