package model; //Define o pacote onde a classe está localizada

//Classe de modelo que representa um usuário do sistema.

public class Usuario{ //Declaração da classe Usuario

    // ==== PROPRIEDADES (ATRIBUTOS) ====
    private int id; //Identificador único do usuário
    private String login; //Nome de usuário utiizado no login
    private String senha; //Senha de acesso
    private String dataCriacao; //Data em que o usuário foi cadastrado
    private String ativo; //Indica se está ativo: "S" ou "N"
    private String tipo; //Tipo de usuário
    private String email; 

    // ==== MÉTODOS GETTERS E SETTERS ====
    // Permitem acessar e modificar atributos privados de forma controlada

    public int getId(){ //Retorna o ID do usuário
        return id;
    }

    public void setId(int id){ //Define o ID do usuário
        this.id=id;
    }

    public String getLogin() { //Retorna o login do usuário
        return login;
    }

    public void setLogin(String login) { //Define o login do usuário
        this.login = login;
    }

    public String getSenha() { //Retorna a senha do usuário
        return senha;
    }

    public void setSenha(String senha) { //Define a senha do usuário
        this.senha = senha;
    }

    public String getDataCriacao() { //Retorna a data de criação
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) { //Define a data de criação
        this.dataCriacao = dataCriacao;
    }

    public String getAtivo() { //Retorna se o usuário está ativo
        return ativo;
    }

    public void setAtivo(String ativo) { //Define se o usuário está ativo
        this.ativo = ativo;
    }

    public String getTipo() { //Retorna o tipo de usuário
        return tipo;
    }

    public void setTipo(String tipo) { //Define o tipo de usuário
        this.tipo = tipo;
    }

    public String getEmail() { //Retorna o email do usuário
        return email;
    }

    public void setEmail(String email) { //Define o email do usuário
        this.email = email;
    }
}