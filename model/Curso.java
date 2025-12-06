package model;


public abstract class Curso {
    protected String nome;
    protected String codigo;
    protected int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria){
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    
   public abstract void detalharCurso();

    public void gerarRelatorio() {
        System.out.println("\nRelatórios do Cursos:");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
        detalharCurso();
    }
}
