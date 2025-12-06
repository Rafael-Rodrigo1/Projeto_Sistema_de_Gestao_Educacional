package repository;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    //método para buscar aluno pela Matricula
    public Aluno buscaPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
      return null;
    }

    








}
