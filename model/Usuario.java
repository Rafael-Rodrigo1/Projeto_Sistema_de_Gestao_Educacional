package model;

public abstract class Usuario implements Autenticacao{

    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }   

    @Override
    public boolean autenticar(String login, int senha) {
        return this.login.equals(login) && this.senha.equals(String.valueOf(senha));
    }   

    public String getNome() {
        return nome;
    }   

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }   
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public abstract void gerarRelatorio();

}
