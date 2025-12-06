package model;

import java.util.ArrayList;
import java.util.List;



public class Aluno extends Usuario {
    private String matricula;
    private String curso;
    private List<Avaliacao> avaliacoes = new ArrayList<>(); 

    public Aluno(String nome, String login, String senha, String matricula, String curso) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso; 
       }

        public String getMatricula() {
        return matricula;
        }

        public void setMatricula(String matricula) {
        this.matricula = matricula;
        }

        public String getCurso() {
        return curso;
        }

        public void setCurso(String curso) {
        this.curso = curso;
        }

        public List<Avaliacao> getAvaliacoes() {    
            return avaliacoes;
        }

        public void adicionarAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }
   
       @Override
    public void gerarRelatorio() {
        System.out.println("Relatórios de Alunos:");
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("Avaliações:");
        for (Avaliacao av : avaliacoes) {
            System.out.println("  Descrição: " + av.getDescricao() + ", Nota: " + av.getNota());
        }
    }
};