package model;


public class Professor extends Usuario {
   private String especialidade;
   private String registro;


    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override 
        public void gerarRelatorio() {
            System.out.println("\nRelatórios de Professores:");
            System.out.println("Nome: " + nome);
            System.out.println("Especialidade: " + especialidade);
            System.out.println("Registro: " + registro);
    }
}
