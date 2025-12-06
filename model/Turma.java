package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String codigo;
    private Professor professor; 
    private Curso curso;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

   
    public void adicionarAluno(Aluno aluno) {
        this.listaAlunos.add(aluno);
    }
  
    public void removerAluno(Aluno aluno) {
        this.listaAlunos.remove(aluno);
    }
    
    public void mostrarResumo() {
        System.out.println("\nResumos de Turmas:");
        System.out.println("Código: " + codigo);
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Quantidade de Alunos: " + listaAlunos.size());
    }
}
    