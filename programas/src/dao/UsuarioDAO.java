package dao; // Pacote onde esta localizado o DAO (Data Access Object)
// Aula 11

// Importação das classes de modelo e utilidades
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import util.Funcoes;
import util.ResultadoCadastro;

// Classe responsável pelo acesso ao banco de dados dos usuários
public class UsuarioDAO {

    // MÉTODO: autenticar usuário
    public boolean autenticar(Usuario usuario) {

        // Consulta SQL para verificar se login e senha existem
        String sql = "SELECT login, senha FROM usuarios " +
                     "WHERE login = ? AND senha = ?";

        // try-with-resources (fecha a conexão automaticamente)
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Preenche os parametros da consulta
            stmt.setString(1, usuario.getLogin());
            // A senha do usuário é convertida para hash SHA-256
            stmt.setString(2, Funcoes.gerarHashSHA256(usuario.getSenha()));

            // Executa a consulta
            ResultSet rs = stmt.executeQuery();

            // Se encontrou registro -> autenticação válida
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return false; // falha por erro no banco
        }
    }


    // MÉTODO: verificar se o usuário já existe
    public boolean existeUsuario(String nomeUsuario) {
        String sql = "SELECT 1 FROM usuarios WHERE login = ?";

        try (Connection minhaConexao = Conexao.conectar();
             PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {

            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // true -> usuario ja existe

        } catch (SQLException e) {
            System.out.println("Erro ao verificar existencia de usuário: " + 
            e.getMessage());
            return false; 
        }
    }

    // MÉTODO: inserir usuário
    public ResultadoCadastro inserir(Usuario dadosInformados) {
        if (existeUsuario(dadosInformados.getLogin())) {
            return ResultadoCadastro.JA_EXISTE; 
        }
    
        // SQL para inserir novo usuário
        String sql = "INSERT INTO usuarios " +
                    "(login, senha, data_criacao, tipo, ativo, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection minhaConexao = Conexao.conectar();
             PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {
            
            stmt.setString(1, dadosInformados.getLogin());
            stmt.setString(2,
                Funcoes.gerarHashSHA256(dadosInformados.getSenha()));
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setString(4, "U"); // Tipo de usuário padrão (U = usuário)
            stmt.setString(5, "T"); // Ativo (T = true)
            stmt.setString(6, ""); // sem email

            stmt.executeUpdate();

            return ResultadoCadastro.SUCESSO;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + 
            e.getMessage());
            return ResultadoCadastro.ERRO_BANCO;
        } 
    }
    //paramos aula 11 22/10
    
}