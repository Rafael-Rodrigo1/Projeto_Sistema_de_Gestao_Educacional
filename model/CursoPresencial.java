package model;


public class CursoPresencial extends Curso {
    private String sala;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        super(nome, codigo, cargaHoraria);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public void detalharCurso() {
        System.out.println("Sala de Aula: " + sala);
    }
}
