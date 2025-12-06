package model;

public class Administrador extends Usuario {
    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }
    
    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório do Administrador:");
        System.out.println("Nome: " + nome);
        System.out.println("Login: " + login);
    }
}
